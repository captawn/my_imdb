package com.example.demo.controller;


import com.example.demo.domain.CartDomain;
import com.example.demo.dto.CartDTO;
import com.example.demo.mapper.CartMapperHelper;
import com.example.demo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController {

    private final CartService cartService;
    private final CartMapperHelper cartMapperHelper;

    @Autowired
    public CartController(CartService cartService, CartMapperHelper cartMapperHelper) {
        this.cartService = cartService;
        this.cartMapperHelper = cartMapperHelper;
    }

    @GetMapping
    public List<CartDTO> getAllCarts() {
        List<CartDomain> cartDomains = cartService.getAllCarts();
        return cartMapperHelper.convertCartDomainListToCartDTOList(cartDomains);
    }

    @PostMapping
    public Long saveCart(@RequestBody CartDTO cartDTO) {
        CartDomain cartDomain = cartMapperHelper.convertCartDTOToCartDomain(cartDTO);
        return cartService.saveCart(cartDomain);
    }

    @GetMapping("/{cartId}")
    public CartDTO getCartById(@PathVariable Long cartId) {
        CartDomain cartDomain = cartService.findCartById(cartId);
        return cartMapperHelper.convertCartDomainToCartDTO(cartDomain);
    }

    @DeleteMapping("/{cartId}")
    public void deleteCartById(@PathVariable Long cartId) {
        cartService.deleteCartById(cartId);
    }
}
