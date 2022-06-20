package com.fmi.merchandise.controller;

import com.fmi.merchandise.dto.CommentDto;
import com.fmi.merchandise.dto.ContentUpdateDto;
import com.fmi.merchandise.dto.DescriptionUpdateDto;
import com.fmi.merchandise.dto.ItemDto;
import com.fmi.merchandise.service.CommentService;
import com.fmi.merchandise.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private final ItemService itemService;
    private final CommentService commentService;

    @Autowired
    public ItemController(ItemService itemService, CommentService commentService) {
        this.itemService = itemService;
        this.commentService = commentService;
    }

    @GetMapping
    public List<ItemDto> getAllItems() {
        //<- id, pic, name
        return itemService.getAllItems();
    }

    @GetMapping("/{itemId}")
    public ItemDto getItemById(@PathVariable Long itemId) {
        return itemService.getItemById(itemId);
    }

    @PostMapping        //no id
    public void addItem(@RequestBody ItemDto itemDto) {
        itemService.addItem(itemDto);
    }

    @PatchMapping("/{itemId}")
    public void updateDescription(@PathVariable Long itemId, @RequestBody DescriptionUpdateDto descriptionUpdateDto) {
        itemService.updateDescription(itemId, descriptionUpdateDto);
    }

    @DeleteMapping("/{itemId}")
    public void deleteItem(@PathVariable Long itemId) {
        itemService.deleteItemById(itemId);
    }

    //Comments:

    @GetMapping("/{itemId}/comments")
    public List<CommentDto> getAllComments(@PathVariable Long itemId) {
        //<- id, username, content
        return commentService.getAllCommentsByItemId(itemId);
    }

    @PostMapping("/{itemId}/comments")               //no id
    public void addComment(@PathVariable Long itemId, @RequestBody CommentDto commentDto) {
        commentService.addComment(itemId, commentDto);
    }

    @PatchMapping("/{itemId}/comments/{commentId}")
    public void updateContent(@PathVariable Long itemId, @PathVariable Long commentId,
                              @RequestBody ContentUpdateDto contentUpdateDto) {
        commentService.updateContent(commentId, contentUpdateDto);
    }

    @DeleteMapping("/{itemId}/comments/{commentId}")
    public void deleteComment(@PathVariable Long itemId, @PathVariable Long commentId) {
        commentService.deleteCommentById(commentId);
    }
}
