package com.fmi.merchandise.service.impl;

import com.fmi.merchandise.dto.DescriptionUpdateDto;
import com.fmi.merchandise.dto.ItemDto;
import com.fmi.merchandise.exceptions.ApiBadRequestException;
import com.fmi.merchandise.exceptions.ApiNotFoundException;
import com.fmi.merchandise.mapper.ItemDtoMapper;
import com.fmi.merchandise.model.Item;
import com.fmi.merchandise.repository.ItemRepository;
import com.fmi.merchandise.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<ItemDto> getAllItems() {
        return ItemDtoMapper.entityListToDtoList(itemRepository.findAll());
    }

    @Override
    public ItemDto getItemById(Long itemId) {
        Optional<Item> item = itemRepository.findById(itemId);
        if (!item.isPresent()) {
            throw new ApiNotFoundException("Non-existing item");
        }

        return ItemDtoMapper.toDto(item.get());
    }

    @Override
    public void addItem(ItemDto itemDto) {
        itemRepository.save(ItemDtoMapper.toEntity(itemDto));
    }

    @Override
    public void deleteItemById(Long itemId) {
        itemRepository.deleteById(itemId);
    }

    @Override
    public void updateDescription(Long itemId, DescriptionUpdateDto descriptionUpdateDto) {
        if (!itemRepository.existsById(itemId)) {
            throw new ApiNotFoundException("Non-existing item");
        }
        if (descriptionUpdateDto == null) {
            throw new ApiBadRequestException("Invalid item description input");
        }

        itemRepository.updateDescription(itemId, descriptionUpdateDto.getDescription());
    }
}
