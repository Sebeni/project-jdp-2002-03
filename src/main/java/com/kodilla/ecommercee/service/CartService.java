package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.CartRepository;
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

    public CartDto createEmptyCart(String name) {
        CartDto newCart = new CartDto("Name");
        cartRepository.save(newCart);
        return newCart;

    }

    public List<ProductDto> getProductsfromCart(CartDto cart) {
        CartDto resultCart = cartRepository.findById(cart.getId()).orElse(new CartDto("Empty Cart"));
        return resultCart.getProducts();
    }

    public void addProductsToCart(List<ProductDto> addedProducts, CartDto cart) {
        CartDto resultCart = cartRepository.findById(cart.getId()).orElse(new CartDto("Empty Cart"));
        resultCart.getProducts().addAll(addedProducts);
        cartRepository.save(resultCart);
    }

    public void removeProductFromCart(ProductDto productToBeRemoved, CartDto cart) {
        CartDto resultCart = cartRepository.findById(cart.getId()).orElse(new CartDto("Empty Cart"));
        List<ProductDto> listOfProducts = resultCart.getProducts();
        listOfProducts.remove(productToBeRemoved);
        resultCart.setProducts(listOfProducts);
        cartRepository.save(resultCart);
    }

    public OrderDto createOrderFromCart(CartDto cart) {
        return new OrderDto("");
    }


}
