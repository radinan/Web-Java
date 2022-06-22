package com.fmi.merchandise.repository;

import com.fmi.merchandise.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    @Modifying
    @Query("UPDATE Item i SET i.description = :description WHERE i.id = :item_id")
    void updateDescription(@Param(value = "item_id") Long id, @Param(value = "description") String description);
}
