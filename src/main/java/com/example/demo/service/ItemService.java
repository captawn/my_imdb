package com.example.demo.service;

import com.example.demo.domain.ItemDomain;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {

    List<ItemDomain> getAllItems();

    Long saveItem(ItemDomain itemDomain);

    ItemDomain findItemById(Long itemId);

    void deleteItemById(Long itemId);

}
