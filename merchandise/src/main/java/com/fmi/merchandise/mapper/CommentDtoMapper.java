package com.fmi.merchandise.mapper;

import com.fmi.merchandise.dto.CommentDto;
import com.fmi.merchandise.model.Comment;
import com.fmi.merchandise.model.Item;
import com.fmi.merchandise.model.User;
import com.fmi.merchandise.repository.ItemRepository;
import com.fmi.merchandise.repository.UserRepository;
import com.fmi.merchandise.validation.validator.EntityValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CommentDtoMapper {
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;

    @Autowired
    public CommentDtoMapper(UserRepository userRepository, ItemRepository itemRepository) {
        this.userRepository = userRepository;
        this.itemRepository = itemRepository;
    }

    public static CommentDto toDto(Comment comment) {
        return new CommentDto(comment.getId(), comment.getContent(), comment.getItem().getId(),
                comment.getAuthor().getUsername());
    }

    public Comment toEntity(CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setContent(commentDto.getContent());

        Optional<User> user = userRepository.findByUsername(commentDto.getUsername());
        EntityValidator.validateUserExists(user, commentDto.getUsername());
        comment.setAuthor(user.get());

        Optional<Item> item = itemRepository.findById(commentDto.getItemId());
        EntityValidator.validateItemExists(item, commentDto.getItemId());
        comment.setItem(item.get());

        return comment;
    }

    public static List<CommentDto> entityListToDtoList(List<Comment> comments) {
        return comments.stream().map(CommentDtoMapper::toDto).collect(Collectors.toList());
    }
}
