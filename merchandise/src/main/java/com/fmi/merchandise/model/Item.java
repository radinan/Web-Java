package com.fmi.merchandise.model;

import lombok.Data;

@Data
public class Item {
    private Long id;
    private String name;
    private String category;
    private Integer price;
}
