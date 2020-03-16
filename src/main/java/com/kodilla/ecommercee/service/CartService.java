package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.CartRepository;
import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.CartDto;
import com.kodilla.ecommercee.domain.OrderDto;
import com.kodilla.ecommercee.domain.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    private List<CartDto> emptyList = new ArrayList<>();

    public Cart createEmptyCart(String name) {
        Cart newCart = new Cart();
        return newCart;

    }

    public List<ProductDto> getProductsfromCart(Long cartId) {
        return new ArrayList<>();
    }

    public void addProductsToCart(List<ProductDto> addedProducts, Long cartId) {

    }

    public void removeProductsFromCart(List<ProductDto> productToBeRemoved, Long cartId1) {

    }

    public OrderDto createOrderFromCart(CartDto cart) {
        return new OrderDto(1L, new ArrayList<>());
    }


}
