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

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    private List<CartDto> emptyList = new ArrayList<>();

    public Cart createEmptyCart(String name) {

        Cart newCart = new Cart();
        cartRepository.save(newCart);
        return newCart;
    }

    public List<ProductDto> getProductsfromCart(CartDto cart) {
        Cart resultCart = cartRepository.findById(cart.getId()).orElse(new Cart());
        return new ArrayList<>();
    }

    public void addProductsToCart(List<ProductDto> addedProducts, CartDto cart) {
        Cart resultCart = cartRepository.findById(cart.getId()).orElse(new Cart());
        cartRepository.save(resultCart);
    }

    public void removeProductFromCart(ProductDto productToBeRemoved, CartDto cart) {

        Cart resultCart = cartRepository.findById(cart.getId()).orElse(new Cart());
        cartRepository.save(resultCart);
    }

    public OrderDto createOrderFromCart(CartDto cart) {
        return new OrderDto(1L, new ArrayList<String>());

    }


}
