package com.fmi.merchandise.mapper;

import com.fmi.merchandise.dto.CommentDto;
import com.fmi.merchandise.dto.ItemDto;
import com.fmi.merchandise.model.Comment;
import com.fmi.merchandise.model.Item;

import java.util.List;
import java.util.stream.Collectors;

public class CommentDtoMapper {
    public static CommentDto toDto(Comment comment) {
        return new CommentDto(comment.getId(), comment.getContent(), comment.getItem(), comment.getAuthor());
    }

    public static Comment toEntity(CommentDto commentDto) {
        return new Comment(commentDto.getId(), commentDto.getContent(), commentDto.getItem(), commentDto.getAuthor());
    }

    public static List<CommentDto> entityListToDtoList(List<Comment> comments) {
        return comments.stream().map(CommentDtoMapper::toDto).collect(Collectors.toList());
    }
}
