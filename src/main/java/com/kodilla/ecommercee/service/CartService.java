package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.CartDto;
import com.kodilla.ecommercee.domain.OrderDto;
import com.kodilla.ecommercee.domain.ProductDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    private List<CartDto> emptyList = new ArrayList<>();

    public CartDto createEmptyCart(String name) {
        return new CartDto(name);
    }

    public List<ProductDto> getProductsfromCart(CartDto cart) {
        return cart.getProducts();
    }

    public void addProductsToCart(List<ProductDto> addedProducts, CartDto cart) {
        cart.getProducts().addAll(addedProducts);
    }

    public boolean removeProductFromCart(ProductDto productToBeRemoved, CartDto cart) {
        return cart.getProducts().remove(productToBeRemoved);
    }

    public OrderDto createOrderFromCart(CartDto cart) {
        return new OrderDto("");
    }


}
