package com.fmi.merchandise.service;

import com.fmi.merchandise.dto.DescriptionUpdateDto;
import com.fmi.merchandise.dto.ItemDto;

import java.util.List;

public interface ItemService {
    List<ItemDto> getAllItems();

    ItemDto getItemById(Long itemId);

    Long addItem(ItemDto itemDto);

    void deleteItemById(Long itemId);

    void updateDescription(Long itemId, DescriptionUpdateDto descriptionUpdateDto);
}
