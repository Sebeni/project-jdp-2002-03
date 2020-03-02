package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.CartRepository;
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

    public CartDto createEmptyCart(String name) {

        CartDto newCart = new CartDto(1L, "TestCart", new ArrayList<>());
        cartRepository.save(newCart);
        return newCart;

    }

    public List<ProductDto> getProductsfromCart(CartDto cart) {
        CartDto resultCart = cartRepository.findById(cart.getId()).orElse(new CartDto(1L, "TestCart", new ArrayList<>()));
        return resultCart.getProducts();
    }

    public void addProductsToCart(List<ProductDto> addedProducts, CartDto cart) {
        CartDto resultCart = cartRepository.findById(cart.getId()).orElse(new CartDto(1L, "TestCart", new ArrayList<>()));
        resultCart.getProducts().addAll(addedProducts);
        cartRepository.save(resultCart);
    }

    public void removeProductFromCart(ProductDto productToBeRemoved, CartDto cart) {
        CartDto resultCart = cartRepository.findById(cart.getId()).orElse(new CartDto(1L, "TestCart", new ArrayList<>()));
        List<ProductDto> listOfProducts = resultCart.getProducts();
        listOfProducts.remove(productToBeRemoved);
        cartRepository.save(resultCart);
    }

    public OrderDto createOrderFromCart(CartDto cart) {
        return new OrderDto(1L, new ArrayList<String>());
    }


}
