package com.fmi.merchandise.repository;

import com.fmi.merchandise.model.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentRepoImpl implements CommentRepository {

    @Override
    public boolean addComment(Comment comment) {

    }

    @Override
    public boolean updateComment(String newDescription) {

    }

    @Override
    public List<Comment> getAllCommentsByItemId(Long id) {
        //Select * from COMMENT where ITEM_ID = id
    }

    @Override
    public void removeCommentByItemIdAndCommentId(Long itemId, Long commentId) {

    }
}
