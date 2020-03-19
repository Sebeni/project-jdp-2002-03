package com.kodilla.ecommercee.controller;


import com.kodilla.ecommercee.domain.*;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/carts")
@CrossOrigin(origins = "*")

public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private CartMapper cartMapper;

    @RequestMapping(method = RequestMethod.POST, value ="/createCart")
    public CartDto createCart() {
        return cartMapper.mapToCartDto(cartService.createEmptyCart());
    }

    @RequestMapping(method = RequestMethod.GET, value ="/getProductsFromCart", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getProductsFromCart(@RequestParam Long cartId) {
        return cartService.getProductsFromCart(cartId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/addProductsToCart", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addProductsToCart(@RequestBody List<Product> productsToBeAdded, @RequestParam Long cartId) {
        cartService.addProductsToCart(productsToBeAdded, cartId);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/removeProductsFromCart", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void removeProductsFromCart(@RequestBody List<Product> productsToBeRemoved, @RequestParam Long cartId) {
        cartService.removeProductsFromCart(productsToBeRemoved,cartId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createOrderFromCart")
    public Order createOrderFromCart(@RequestBody CartDto cartDto){
        return cartService.createOrderFromCart(cartMapper.mapToCart(cartDto));
    }

}