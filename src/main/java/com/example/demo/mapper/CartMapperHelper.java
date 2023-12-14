package com.example.demo.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.demo.domain.CartDomain;
import com.example.demo.dto.CartDTO;
import com.example.demo.entity.CartEntity;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CartMapperHelper {

    private final ObjectMapper mapper;

    @Autowired
    public CartMapperHelper(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public List<CartDomain> convertCartEntityListToCartDomainList(List<CartEntity> cartEntities) {
        return cartEntities.stream()
                .map(this::convertCartEntityToCartDomain)
                .collect(Collectors.toList());
    }

    public List<CartDTO> convertCartDomainListToCartDTOList(List<CartDomain> cartDomains) {
        return cartDomains.stream()
                .map(this::convertCartDomainToCartDTO)
                .collect(Collectors.toList());
    }

    public CartDTO convertCartDomainToCartDTO(CartDomain cartDomain) {
        return mapper.convertValue(cartDomain, CartDTO.class);
    }

    public CartEntity convertCartDomainToCartEntity(CartDomain cartDomain) {
        CartEntity cartEntity = mapper.convertValue(cartDomain, CartEntity.class);

        // Manually set the ItemEntity for the CartEntity
/*        if (cartDomain.getItem() != null) {
            ItemEntity itemEntity = mapper.convertValue(cartDomain.getItem(), ItemEntity.class);
            cartEntity.setItemEntity(itemEntity);
        }*/

        return cartEntity;
    }

    public CartDomain convertCartDTOToCartDomain(CartDTO cartDTO) {
        return mapper.convertValue(cartDTO, CartDomain.class);
    }

    public CartDomain convertCartEntityToCartDomain(CartEntity cartEntity) {
        CartDomain cartDomain = mapper.convertValue(cartEntity, CartDomain.class);

        // Manually set the items to null to break the circular reference
//        cartDomain.setItems(null);

        return cartDomain;
    }
}
