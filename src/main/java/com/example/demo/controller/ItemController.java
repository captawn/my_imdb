package com.example.demo.controller;


import com.example.demo.domain.ItemDomain;
import com.example.demo.dto.ItemDTO;
import com.example.demo.mapper.ItemMapperHelper;
import com.example.demo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;
    private final ItemMapperHelper itemMapperHelper;

    @Autowired
    public ItemController(ItemService itemService, ItemMapperHelper itemMapperHelper) {
        this.itemService = itemService;
        this.itemMapperHelper = itemMapperHelper;
    }

    @GetMapping
    public List<ItemDTO> getAllItems() {
        List<ItemDomain> itemDomains = itemService.getAllItems();
        return itemMapperHelper.convertItemDomainListToItemDTOList(itemDomains);
    }

    @PostMapping
    public Long saveItem(@RequestBody ItemDTO itemDTO) {
        ItemDomain itemDomain = itemMapperHelper.convertItemDTOToItemDomain(itemDTO);
        return itemService.saveItem(itemDomain);
    }

    @GetMapping("/{itemId}")
    public ItemDTO getItemById(@PathVariable Long itemId) {
        ItemDomain itemDomain = itemService.findItemById(itemId);
        return itemMapperHelper.convertItemDomainToItemDTO(itemDomain);
    }

    @DeleteMapping("/{itemId}")
    public void deleteItemById(@PathVariable Long itemId) {
        itemService.deleteItemById(itemId);
    }
}
