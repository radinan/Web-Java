package com.fmi.merchandise.controller;

import com.fmi.merchandise.dto.CommentDto;
import com.fmi.merchandise.dto.ContentUpdateDto;
import com.fmi.merchandise.dto.DescriptionUpdateDto;
import com.fmi.merchandise.dto.ItemDto;
import com.fmi.merchandise.service.CommentService;
import com.fmi.merchandise.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {
    private final static String ID_RESPONSE_PATTERN = "{\n\t\"id\": %d\n}";
    private final ItemService itemService;
    private final CommentService commentService;

    @Autowired
    public ItemController(ItemService itemService, CommentService commentService) {
        this.itemService = itemService;
        this.commentService = commentService;
    }

    @GetMapping
    public List<ItemDto> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/{itemId}")
    public ItemDto getItemById(@PathVariable Long itemId) {
        return itemService.getItemById(itemId);
    }

    @PostMapping
    public ResponseEntity<Object> addItem(@RequestBody ItemDto itemDto) {
        Long id = itemService.addItem(itemDto);
        return new ResponseEntity<>(String.format(ID_RESPONSE_PATTERN, id), HttpStatus.CREATED);
    }

    @PatchMapping("/{itemId}")
    public ResponseEntity<Object> updateDescription(@PathVariable Long itemId, @RequestBody DescriptionUpdateDto descriptionUpdateDto) {
        itemService.updateDescription(itemId, descriptionUpdateDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<Object> deleteItem(@PathVariable Long itemId) {
        itemService.deleteItemById(itemId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //Comments:

    @GetMapping("/{itemId}/comments")
    public List<CommentDto> getAllComments(@PathVariable Long itemId) {
        return commentService.getAllCommentsByItemId(itemId);
    }

    @PostMapping("/{itemId}/comments")
    public ResponseEntity<Object> addComment(@PathVariable Long itemId, @RequestBody CommentDto commentDto) {
        Long id = commentService.addComment(itemId, commentDto);
        return new ResponseEntity<>(String.format(ID_RESPONSE_PATTERN, id), HttpStatus.CREATED);
    }

    @PatchMapping("/{itemId}/comments/{commentId}")
    public ResponseEntity<Object> updateContent(@PathVariable Long itemId, @PathVariable Long commentId,
                                                @RequestBody ContentUpdateDto contentUpdateDto) {
        commentService.updateContent(itemId, commentId, contentUpdateDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{itemId}/comments/{commentId}")
    public ResponseEntity<Object> deleteComment(@PathVariable Long itemId, @PathVariable Long commentId) {
        commentService.deleteCommentById(itemId, commentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
