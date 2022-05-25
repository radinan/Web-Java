package com.fmi.merchandise.repository;

import com.fmi.merchandise.model.Item;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemRepoImpl implements ItemRepository {
    @Override
    public List<Item> getAllItems() {

    }

    @Override
    public Item findById(Long id) {

    }

    @Override
    public boolean addItem(Item item) {

    }

    @Override
    public boolean removeItem(Long id) {

    }
}
