package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.repository.CartRepository;
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
        return newCart;
    }

    public List<ProductDto> getProductsfromCart(Long cartId) {
        return new ArrayList<>();
    }

    public void addProductsToCart(List<ProductDto> addedProducts, Long cartId) {

    }

<<<<<<< HEAD
    public void removeProductFromCart(ProductDto productToBeRemoved, CartDto cart) {

        Cart resultCart = cartRepository.findById(cart.getId()).orElse(new Cart());
        cartRepository.save(resultCart);
=======
    public void removeProductsFromCart(List<ProductDto> productToBeRemoved, Long cartId1) {

>>>>>>> 742aa5c099ab0145daa1b105528ee1810daa444e
    }

    public OrderDto createOrderFromCart(CartDto cart) {

        return new OrderDto(1L, new ArrayList<>());
    }


}
