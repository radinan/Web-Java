package com.fmi.merchandise.model;

import lombok.Data;

@Data
public class Comment {
    Long id;
    String content;
    private Item item;
    private User author;
}
