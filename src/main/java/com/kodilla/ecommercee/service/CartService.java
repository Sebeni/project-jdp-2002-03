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

<<<<<<< HEAD
    public CartDto createEmptyCart(String name) {

        CartDto newCart = new CartDto(1L, "TestCart", new ArrayList<>());
=======
    public Cart createEmptyCart(String name) {
        Cart newCart = new Cart();
>>>>>>> 85cf5127bf62d8e46ac093f0442f63cfe01b6493
        cartRepository.save(newCart);
        return newCart;

    }

    public List<ProductDto> getProductsfromCart(CartDto cart) {
<<<<<<< HEAD
        CartDto resultCart = cartRepository.findById(cart.getId()).orElse(new CartDto(1L, "TestCart", new ArrayList<>()));
        return resultCart.getProducts();
    }

    public void addProductsToCart(List<ProductDto> addedProducts, CartDto cart) {
        CartDto resultCart = cartRepository.findById(cart.getId()).orElse(new CartDto(1L, "TestCart", new ArrayList<>()));
        resultCart.getProducts().addAll(addedProducts);
=======
        Cart resultCart = cartRepository.findById(cart.getId()).orElse(new Cart());
        return new ArrayList<>();
    }

    public void addProductsToCart(List<ProductDto> addedProducts, CartDto cart) {
        Cart resultCart = cartRepository.findById(cart.getId()).orElse(new Cart());
>>>>>>> 85cf5127bf62d8e46ac093f0442f63cfe01b6493
        cartRepository.save(resultCart);
    }

    public void removeProductFromCart(ProductDto productToBeRemoved, CartDto cart) {
<<<<<<< HEAD
        CartDto resultCart = cartRepository.findById(cart.getId()).orElse(new CartDto(1L, "TestCart", new ArrayList<>()));
        List<ProductDto> listOfProducts = resultCart.getProducts();
        listOfProducts.remove(productToBeRemoved);
=======
        Cart resultCart = cartRepository.findById(cart.getId()).orElse(new Cart());
>>>>>>> 85cf5127bf62d8e46ac093f0442f63cfe01b6493
        cartRepository.save(resultCart);
    }

    public OrderDto createOrderFromCart(CartDto cart) {
<<<<<<< HEAD
        return new OrderDto(1L, new ArrayList<String>());
=======
        return new OrderDto();
>>>>>>> 85cf5127bf62d8e46ac093f0442f63cfe01b6493
    }


}
