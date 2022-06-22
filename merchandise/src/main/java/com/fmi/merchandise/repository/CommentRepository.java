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
    @Query("DELETE FROM merch_comments WHERE id = :comment_id")
    void deleteById(@Param("comment_id") Long commentId);

    @Modifying
    @Query("UPDATE merch_comments SET content = :content WHERE id = :comment_id")
    void updateContentById(@Param("comment_id") Long commentId, @Param("content") String content);
}
