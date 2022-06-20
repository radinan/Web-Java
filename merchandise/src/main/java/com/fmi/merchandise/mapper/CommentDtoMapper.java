package com.fmi.merchandise.mapper;

import com.fmi.merchandise.dto.CommentDto;
import com.fmi.merchandise.model.Comment;

import java.util.List;
import java.util.stream.Collectors;

public class CommentDtoMapper {
    public static CommentDto toDto(Comment comment) {
        return new CommentDto(comment.getId(), comment.getContent(), comment.getAuthor().getUserName());
    }

    public static Comment toEntity(CommentDto commentDto) {
        //TODO: create mapper; fetch user; fetch item(if present)
        return null;
    }

    public static List<CommentDto> entityListToDtoList(List<Comment> comments) {
        return comments.stream().map(CommentDtoMapper::toDto).collect(Collectors.toList());
    }
}
