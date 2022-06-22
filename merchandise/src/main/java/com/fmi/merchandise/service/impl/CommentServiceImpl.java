package com.fmi.merchandise.service.impl;

import com.fmi.merchandise.dto.CommentDto;
import com.fmi.merchandise.dto.ContentUpdateDto;
import com.fmi.merchandise.mapper.CommentDtoMapper;
import com.fmi.merchandise.model.Comment;
import com.fmi.merchandise.repository.CommentRepository;
import com.fmi.merchandise.repository.ItemRepository;
import com.fmi.merchandise.service.CommentService;
import com.fmi.merchandise.validation.validator.EntityValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final ItemRepository itemRepository;
    private final CommentDtoMapper commentDtoMapper;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, ItemRepository itemRepository,
                              CommentDtoMapper commentDtoMapper) {
        this.commentRepository = commentRepository;
        this.itemRepository = itemRepository;
        this.commentDtoMapper = commentDtoMapper;
    }

    @Override
    public List<CommentDto> getAllCommentsByItemId(Long itemId) {
        EntityValidator.validateItemExists(itemRepository.findById(itemId), itemId);
        return CommentDtoMapper.entityListToDtoList(commentRepository.findCommentsByItemId(itemId));
    }

    @Override
    public Long addComment(Long itemId, CommentDto commentDto) {
        EntityValidator.validateItemExists(itemRepository.findById(itemId), itemId);

        commentDto.setItemId(itemId);
        Comment comment = commentDtoMapper.toEntity(commentDto);
        return commentRepository.save(comment).getId();
    }

    @Override
    public void updateContent(Long itemId, Long commentId, ContentUpdateDto content) {
        EntityValidator.validateItemExists(itemRepository.findById(itemId), itemId);
        EntityValidator.validateCommentExists(commentRepository.findById(commentId), commentId);

        commentRepository.updateContentById(commentId, content.getContent());
    }

    @Override
    public void deleteCommentById(Long itemId, Long commentId) {
        EntityValidator.validateItemExists(itemRepository.findById(itemId), itemId);
        EntityValidator.validateCommentExists(commentRepository.findById(commentId), commentId);

        commentRepository.deleteById(commentId);
    }

}
