package com.fmi.merchandise.mapper;

import com.fmi.merchandise.dto.CommentDto;
import com.fmi.merchandise.exceptions.ApiNotFoundException;
import com.fmi.merchandise.model.Comment;
import com.fmi.merchandise.model.Item;
import com.fmi.merchandise.model.User;
import com.fmi.merchandise.repository.ItemRepository;
import com.fmi.merchandise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CommentDtoMapper {
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;

    @Autowired
    public CommentDtoMapper(UserRepository userRepository, ItemRepository itemRepository) {
        this.userRepository = userRepository;
        this.itemRepository = itemRepository;
    }

    public static CommentDto toDto(Comment comment) {
        return new CommentDto(comment.getId(), comment.getContent(), comment.getItem().getId(), comment.getAuthor().getUserName());
    }

    public Comment toEntity(CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setContent(commentDto.getContent());

        Optional<User> user = userRepository.findByUserName(commentDto.getUsername());
        if (user.isPresent()) {
            comment.setAuthor(user.get());
        } else {
            throw new ApiNotFoundException("User with username: \"" + commentDto.getUsername() + "\" not found");
        }

        Optional<Item> item = itemRepository.findById(commentDto.getItemId());
        if (item.isPresent()) {
            comment.setItem(item.get());
        } else {
            throw new ApiNotFoundException("Item with id: " + commentDto.getItemId().toString() + " not found");
        }
        return null;
    }

    public static List<CommentDto> entityListToDtoList(List<Comment> comments) {
        return comments.stream().map(CommentDtoMapper::toDto).collect(Collectors.toList());
    }
}
