package com.example.demo.service;

import com.example.demo.domain.CartDomain;

import java.util.List;

public interface CartService {

    List<CartDomain> getAllCarts();

    Long saveCart(CartDomain cartDomain);

    CartDomain findCartById(Long cartId);

    void deleteCartById(Long cartId);
}
