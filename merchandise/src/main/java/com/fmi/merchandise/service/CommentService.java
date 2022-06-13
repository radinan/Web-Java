package com.fmi.merchandise.service;

import com.fmi.merchandise.dto.CommentDto;
import com.fmi.merchandise.mapper.CommentDtoMapper;
import com.fmi.merchandise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<CommentDto> getAllCommentsByItemId(Long itemId) {
        return CommentDtoMapper.entityListToDtoList(commentRepository.getAllCommentsByItemId(itemId));
    }

    public void deleteCommentByItemIdAndCommentId(Long itemId, Long commentId) {
        commentRepository.removeCommentByItemIdAndCommentId(itemId, commentId);
    }
}
