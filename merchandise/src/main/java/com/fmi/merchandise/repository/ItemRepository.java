package com.fmi.merchandise.repository;

import com.fmi.merchandise.model.Comment;
import com.fmi.merchandise.model.Item;

import java.util.List;

public interface ItemRepository {

    public List<Item> getAllItems();

    public Item findById(Long id);

    public boolean addItem(Item item);

    public boolean removeItem(Long id);
}
