package com.fmi.merchandise.dto;

import com.fmi.merchandise.model.Item;
import com.fmi.merchandise.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {
    Long id;
    String content;
    private Item item;
    private User author;
}
