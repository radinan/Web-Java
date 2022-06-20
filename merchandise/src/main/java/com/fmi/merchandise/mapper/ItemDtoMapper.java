package com.fmi.merchandise.mapper;

import com.fmi.merchandise.dto.ItemDto;
import com.fmi.merchandise.model.Item;

import java.util.List;
import java.util.stream.Collectors;

public class ItemDtoMapper {
    public static ItemDto toDto(Item item) {
        return new ItemDto(item.getId(), item.getName(), item.getDescription(),
                item.getCategory(), item.getPrice(), item.getPicture());
    }

    public static Item toEntity(ItemDto itemDto) {
         Item item = new Item();
         item.setName(itemDto.getName());
         item.setDescription(itemDto.getDescription());
         item.setCategory(itemDto.getCategory());
         item.setPrice(itemDto.getPrice());
         item.setPicture(itemDto.getPicture());
         return item;
    }

    public static List<ItemDto> entityListToDtoList(List<Item> items) {
        return items.stream()
                .map(ItemDtoMapper::toDto)
                .collect(Collectors.toList());
    }
}
