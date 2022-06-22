package com.fmi.merchandise.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Data
@Table(name = "merch_items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;
    private String category;
    private Double price;
    private String picture;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.PERSIST, mappedBy = "item")
    private List<Comment> comments;
}
