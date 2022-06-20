package com.fmi.merchandise.service;

import com.fmi.merchandise.dto.CommentDto;
import com.fmi.merchandise.dto.ContentUpdateDto;

import java.util.List;

public interface CommentService {
    List<CommentDto> getAllCommentsByItemId(Long itemId);

    void deleteCommentById(Long commentId);

    void addComment(Long itemId, CommentDto commentDto);

    void updateContent(Long commentId, ContentUpdateDto content);
}
