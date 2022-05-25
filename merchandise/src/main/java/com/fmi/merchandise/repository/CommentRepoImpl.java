package com.fmi.merchandise.repository;

import com.fmi.merchandise.model.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentRepoImpl implements CommentRepository {
    @Override
    public List<Comment> getAllCommentsForItem() {

    }

    @Override
    public boolean addComment(Comment comment) {

    }

    @Override
    public boolean removeComment(Long id) {

    }

    @Override
    public boolean updateComment(String newDescription) {

    }
}
