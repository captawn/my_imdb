package com.example.demo.service;


import com.example.demo.domain.ItemDomain;
import com.example.demo.entity.ItemEntity;
import com.example.demo.mapper.ItemMapperHelper;
import com.example.demo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final ItemMapperHelper itemMapperHelper;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository, ItemMapperHelper itemMapperHelper) {
        this.itemRepository = itemRepository;
        this.itemMapperHelper = itemMapperHelper;
    }

    @Override
    public List<ItemDomain> getAllItems() {
        List<ItemEntity> itemEntities = itemRepository.findAll();
        List<ItemDomain> itemDomains = itemMapperHelper.convertItemEntityListToItemDomainList(itemEntities);
        return itemDomains;
    }

    @Override
    public Long saveItem(ItemDomain itemDomain) {
        ItemEntity itemEntity = itemMapperHelper.convertItemDomainToItemEntity(itemDomain);
        ItemEntity savedItem = itemRepository.save(itemEntity);
        return savedItem.getId();
    }

    @Override
    public ItemDomain findItemById(Long itemId) {
        Optional<ItemEntity> byId = itemRepository.findById(itemId);
        if (byId.isPresent()) {
            ItemEntity itemEntity = byId.get();
            return itemMapperHelper.convertItemEntityToItemDomain(itemEntity);
        }
        return null;
    }

    @Override
    public void deleteItemById(Long itemId) {
        itemRepository.deleteById(itemId);
    }
}
