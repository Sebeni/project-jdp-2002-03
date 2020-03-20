package com.kodilla.ecommercee.controller;


import com.kodilla.ecommercee.domain.*;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.mapper.OrderMapper;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/carts")
@CrossOrigin(origins = "*")

public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private OrderMapper orderMapper;

    @RequestMapping(method = RequestMethod.POST, value ="/createCart")
    public CartDto createCart() {
        return cartMapper.mapToCartDto(cartService.createEmptyCart());
    }

    @RequestMapping(method = RequestMethod.GET, value ="/getProductsFromCart", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductDto> getProductsFromCart(@RequestParam Long cartId) {

        return cartService.getProductsFromCart(cartId).stream()
                .map(p -> productMapper.mapToProductDto(p))
                .collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/addProductsToCart", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addProductsToCart(@RequestBody List<ProductDto> productsToBeAdded, @RequestParam Long cartId) {

        List<Product> productsToBeUsedWithService = productsToBeAdded.stream()
                .map(p-> productMapper.mapToProduct(p))
                .collect(Collectors.toList());

        cartService.addProductsToCart(productsToBeUsedWithService, cartId);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/removeProductsFromCart", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void removeProductsFromCart(@RequestBody List<ProductDto> productsToBeRemoved, @RequestParam Long cartId) {

        List<Product> productsToBeUsedWithService = productsToBeRemoved.stream()
                .map(p-> productMapper.mapToProduct(p))
                .collect(Collectors.toList());

        cartService.removeProductsFromCart(productsToBeUsedWithService,cartId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createOrderFromCart")
    public OrderDto createOrderFromCart(@RequestBody CartDto cartDto){

        return orderMapper.mapToOrderDto(cartService.createOrderFromCart(cartMapper.mapToCart(cartDto)));
    }

}