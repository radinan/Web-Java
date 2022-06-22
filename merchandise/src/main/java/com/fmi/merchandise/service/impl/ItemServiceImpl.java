package com.fmi.merchandise.service.impl;

import com.fmi.merchandise.dto.DescriptionUpdateDto;
import com.fmi.merchandise.dto.ItemDto;
import com.fmi.merchandise.mapper.ItemDtoMapper;
import com.fmi.merchandise.model.Item;
import com.fmi.merchandise.repository.ItemRepository;
import com.fmi.merchandise.service.ItemService;
import com.fmi.merchandise.validation.validator.EntityValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
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
        EntityValidator.validateItemExists(item, itemId);

        return ItemDtoMapper.toDto(item.get());
    }

    @Override
    public Long addItem(ItemDto itemDto) {
        return itemRepository.save(ItemDtoMapper.toEntity(itemDto)).getId();
    }

    @Override
    public void deleteItemById(Long itemId) {
        EntityValidator.validateItemExists(itemRepository.findById(itemId), itemId);

        itemRepository.deleteById(itemId);
    }

    @Override
    public void updateDescription(Long itemId, DescriptionUpdateDto descriptionUpdateDto) {
        EntityValidator.validateItemExists(itemRepository.findById(itemId), itemId);

        itemRepository.updateDescription(itemId, descriptionUpdateDto.getDescription());
    }
}
