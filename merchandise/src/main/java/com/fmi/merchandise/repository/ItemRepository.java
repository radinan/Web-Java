package com.fmi.merchandise.repository;

import com.fmi.merchandise.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//change optional
@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
//    List<Item> findAll();
//
//    Item getItemById(Long id);
//
//    Item save(Item item);
//
//    //update
//
//    void deleteById(Long id);
}
