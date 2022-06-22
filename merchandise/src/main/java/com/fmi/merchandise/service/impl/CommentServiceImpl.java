package com.fmi.merchandise.service.impl;

import com.fmi.merchandise.dto.CommentDto;
import com.fmi.merchandise.dto.ContentUpdateDto;
import com.fmi.merchandise.exceptions.ApiBadRequestException;
import com.fmi.merchandise.exceptions.ApiNotFoundException;
import com.fmi.merchandise.mapper.CommentDtoMapper;
import com.fmi.merchandise.model.Comment;
import com.fmi.merchandise.repository.CommentRepository;
import com.fmi.merchandise.repository.ItemRepository;
import com.fmi.merchandise.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final ItemRepository itemRepository;
    private final CommentDtoMapper commentDtoMapper;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, ItemRepository itemRepository,
                              CommentDtoMapper commentDtoMapper) {
        this.commentRepository = commentRepository;
        this.itemRepository = itemRepository;
        this.commentDtoMapper = commentDtoMapper;
    }

    @Override
    public List<CommentDto> getAllCommentsByItemId(Long itemId) {
        return CommentDtoMapper.entityListToDtoList(commentRepository.findCommentsByItemId(itemId));
    }

    @Override
    public void deleteCommentById(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    @Override
    public void addComment(Long itemId, CommentDto commentDto) {
        if (!itemRepository.existsById(itemId)) {
            throw new ApiNotFoundException("Item with id: " + itemId.toString() + " not found");
        }
        if (commentDto == null) {
            throw new ApiBadRequestException("Comment dto is null");
        }

        Comment newEntity = commentDtoMapper.toEntity(commentDto);
        newEntity.setId(itemId);
        commentRepository.save(newEntity);
    }

    @Override
    public void updateContent(Long commentId, ContentUpdateDto content) {
        if (!commentRepository.existsById(commentId)) {
            throw new ApiNotFoundException("Item with id: " + commentId.toString() + " not found");
        }
        if (content == null) {
            throw new ApiBadRequestException("New comment content is null");
        }

        commentRepository.updateContentById(commentId, content.getContent());
    }
}
