package com.fmi.merchandise.service.impl;

import com.fmi.merchandise.dto.CommentDto;
import com.fmi.merchandise.dto.ContentUpdateDto;
import com.fmi.merchandise.mapper.CommentDtoMapper;
import com.fmi.merchandise.repository.CommentRepository;
import com.fmi.merchandise.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<CommentDto> getAllCommentsByItemId(Long itemId) {
        return CommentDtoMapper.entityListToDtoList(commentRepository.findCommentsByItemId(itemId));
    }

    @Override
    public void deleteCommentById(Long commentId) {
        //TODO: delete method
    }

    @Override
    public void addComment(Long itemId, CommentDto commentDto) {
        // 1. map to entity
        // 2. set itemId
        //TODO: save method

    }

    @Override
    public void updateContent(Long commentId, ContentUpdateDto content) {
        //TODO: custom query in comment table where id=={commentId} set content={content}
    }
}
