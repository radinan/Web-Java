package com.fmi.merchandise.controller;

import com.fmi.merchandise.dto.CommentDto;
import com.fmi.merchandise.dto.ItemDto;
import com.fmi.merchandise.service.CommentService;
import com.fmi.merchandise.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {
    private ItemService itemService;
    private CommentService commentService;

    @Autowired
    public ItemController(ItemService itemService, CommentService commentService) {
        this.itemService = itemService;
        this.commentService = commentService;
    }

    @GetMapping
    public List<ItemDto> getAllItems() {
        return null;
    }

    @GetMapping("/{itemId}")
    public ItemDto getItemById(@PathVariable Long itemId) {
        return null;
    }

    @GetMapping("/{itemId}/comments")
    public List<CommentDto> getCommentsByItemId(@PathVariable Long itemId) {
        return null;
    }

    @PostMapping
    public void addItem(@RequestBody ItemDto itemDto) {

    }

    @PostMapping("/{itemId}/comments")
    public void addComment(@PathVariable Long itemId, @RequestBody CommentDto commentDto) {

    }

    @PutMapping("/{itemId}/description") //maybe change requestBody
    public void updateDescription(@PathVariable Long itemId, @RequestBody ItemDto itemDto) {

    }

    @PutMapping("/{itemId}/comments/{commentId}")
    public void updateComment(@PathVariable Long itemId, @PathVariable Long commentId, @RequestBody CommentDto commentDto) {

    }

    @DeleteMapping("/{itemId}")
    public void deleteItem(@PathVariable Long itemId) {

    }

    @DeleteMapping("/{itemId}/comments/{commentId}")
    public void deleteComment(@PathVariable Long itemId, @PathVariable Long commentId) {

    }
}
