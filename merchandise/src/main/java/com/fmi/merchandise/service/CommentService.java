package com.fmi.merchandise.service;

import com.fmi.merchandise.dto.CommentDto;
import com.fmi.merchandise.dto.ContentUpdateDto;

import java.util.List;

public interface CommentService {
    List<CommentDto> getAllCommentsByItemId(Long itemId);

    void deleteCommentById(Long itemId, Long commentId);

    Long addComment(Long itemId, CommentDto commentDto);

    void updateContent(Long itemId, Long commentId, ContentUpdateDto content);
}
