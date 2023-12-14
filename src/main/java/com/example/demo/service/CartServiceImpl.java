package com.example.demo.service;

import com.example.demo.domain.CartDomain;
import com.example.demo.entity.CartEntity;
import com.example.demo.mapper.CartMapperHelper;
import com.example.demo.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {
    private  CartRepository cartRepository;
    private  CartMapperHelper cartMapperHelper;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository, CartMapperHelper cartMapperHelper) {
        this.cartRepository = cartRepository;
        this.cartMapperHelper = cartMapperHelper;
    }

    @Override
    public List<CartDomain> getAllCarts() {
        List<CartEntity> cartEntities = cartRepository.findAll();
        return cartMapperHelper.convertCartEntityListToCartDomainList(cartEntities);
    }

    @Override
    public Long saveCart(CartDomain cartDomain) {
        CartEntity cartEntity = cartMapperHelper.convertCartDomainToCartEntity(cartDomain);
        CartEntity savedCart = cartRepository.save(cartEntity);
        return savedCart.getId();
    }

    @Override
    public CartDomain findCartById(Long cartId) {
        Optional<CartEntity> byId = cartRepository.findById(cartId);
        if (byId.isPresent()) {
            CartEntity cartEntity = byId.get();
            return cartMapperHelper.convertCartEntityToCartDomain(cartEntity);
        }
        return null;
    }

    @Override
    public void deleteCartById(Long cartId) {
        cartRepository.deleteById(cartId);
    }
}
