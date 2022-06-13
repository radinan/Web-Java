package com.fmi.merchandise.mapper;

import com.fmi.merchandise.dto.ItemDto;
import com.fmi.merchandise.model.Item;

import java.util.List;
import java.util.stream.Collectors;

public class ItemDtoMapper {
    public static ItemDto toDto(Item item) {
        return new ItemDto(item.getId(), item.getName(), item.getCategory(), item.getPrice());
    }

    public static Item toEntity(ItemDto itemDto) {
        return new Item(itemDto.getId(), itemDto.getName(), itemDto.getCategory(), itemDto.getPrice());
    }

    public static List<ItemDto> entityListToDtoList(List<Item> items) {
        return items.stream().map(ItemDtoMapper::toDto).collect(Collectors.toList());
    }
}
