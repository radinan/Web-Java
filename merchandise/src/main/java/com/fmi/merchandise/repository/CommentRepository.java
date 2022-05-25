package com.fmi.merchandise.repository;

import com.fmi.merchandise.model.Comment;

import java.util.List;

public interface CommentRepository {

    public List<Comment> getAllCommentsForItem();

    public boolean addComment(Comment comment);

    public boolean removeComment(Long id);

    public boolean updateComment(String newDescription);
}
