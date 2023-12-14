package com.example.demo.mapper;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.demo.domain.CartDomain;
import com.example.demo.domain.ItemDomain;
import com.example.demo.dto.ItemDTO;
import com.example.demo.entity.ItemEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ItemMapperHelper {

    private final ObjectMapper mapper;
    private final CartMapperHelper cartMapperHelper;

    @Autowired
    public ItemMapperHelper(ObjectMapper mapper,  CartMapperHelper cartMapperHelper) {
        this.mapper = mapper;
        this.cartMapperHelper = cartMapperHelper;

    }

    public List<ItemDomain> convertItemEntityListToItemDomainList(List<ItemEntity> itemEntities) {
        List<ItemDomain> collect = itemEntities.stream()
                .map(this::convertItemEntityToItemDomain)
                .collect(Collectors.toList());
        return collect;
    }

    public List<ItemDTO> convertItemDomainListToItemDTOList(List<ItemDomain> itemDomains) {
        List<ItemDTO> collect = itemDomains.stream()
                .map(this::convertItemDomainToItemDTO)
                .collect(Collectors.toList());
        return collect;
    }

    public ItemDTO convertItemDomainToItemDTO(ItemDomain itemDomain) {
        ItemDTO itemDTO = mapper.convertValue(itemDomain, ItemDTO.class);
        return itemDTO;
    }

    public ItemEntity convertItemDomainToItemEntity(ItemDomain itemDomain) {
        ItemEntity itemEntity = mapper.convertValue(itemDomain, ItemEntity.class);
        return itemEntity;
        // You may need to manually set relationships or perform additional mapping depending on your entity structure
    }

    public ItemDomain convertItemDTOToItemDomain(ItemDTO itemDTO) {
        ItemDomain itemDomain = mapper.convertValue(itemDTO, ItemDomain.class);
        return itemDomain;
    }

    public ItemDomain convertItemEntityToItemDomain(ItemEntity itemEntity) {

        ItemDomain itemDomain = ItemDomain.builder()
                .id(itemEntity.getId())
                .itemName(itemEntity.getItemName())
                .cart(cartMapperHelper.convertCartEntityToCartDomain(itemEntity.getCart()))
                .build();


        return itemDomain;
    }
}
