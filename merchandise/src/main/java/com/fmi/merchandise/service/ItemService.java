package com.fmi.merchandise.service;

import com.fmi.merchandise.dto.CommentDto;
import com.fmi.merchandise.dto.ItemDto;
import com.fmi.merchandise.mapper.CommentDtoMapper;
import com.fmi.merchandise.mapper.ItemDtoMapper;
import com.fmi.merchandise.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.HttpMediaTypeNotAcceptableException;

import java.util.List;

@Service
public class ItemService {
    private ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<ItemDto> getAllItems() {
        return ItemDtoMapper.entityListToDtoList(itemRepository.getAllItems());
    }

    public ItemDto getItemById(Long itemId) {
        return ItemDtoMapper.toDto(itemRepository.findById(itemId));
    }

    public void addItem(ItemDto itemDto) {
        if (itemDto == null || itemDto.getId() != 0 || itemDto.getName().isBlank()) {
            //TODO throw new HttpMediaTypeNotAcceptableException("Invalid object");
        }

        itemRepository.addItem(ItemDtoMapper.toEntity(itemDto));
    }

    public void deleteItemById(Long itemId) {
        itemRepository.removeItem(itemId);
    }
}
