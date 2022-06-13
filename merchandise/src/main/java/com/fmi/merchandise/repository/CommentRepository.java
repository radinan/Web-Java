package com.fmi.merchandise.repository;

import com.fmi.merchandise.model.Comment;

import java.util.List;

public interface CommentRepository {

    public boolean addComment(Comment comment);

    public boolean updateComment(String newDescription);

    List<Comment> getAllCommentsByItemId(Long itemId);

    void removeCommentByItemIdAndCommentId(Long itemId, Long commentId);
}
