package com.fmi.merchandise.repository;

import com.fmi.merchandise.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findCommentsByItemId(Long itemId);

    @Modifying
    @Query("UPDATE Comment c SET c.content = :content WHERE c.id = :comment_id")
    void updateContentById(@Param(value = "comment_id") Long commentId, @Param(value = "content") String content);
}
