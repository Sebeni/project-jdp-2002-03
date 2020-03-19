package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.*;
import com.kodilla.ecommercee.exception.CartNotFoundException;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public Cart createEmptyCart() {

        Cart newCart = new Cart();
        return newCart;

    }

    public List<Product> getProductsFromCart(Long cartId) {

        Optional<Cart> cartToBeProcessed = cartRepository.findById(cartId);

        if (cartToBeProcessed.isPresent()) {
            List<Product> listToBeReturned = new ArrayList<>(cartToBeProcessed
                    .get()
                    .getProducts()
                    .keySet());
            return listToBeReturned;
        }
        else throw new CartNotFoundException();
    }

    public void addProductsToCart(List<Product> addedProducts, Long cartId) {

        Optional<Cart> cartToBeProcessed = cartRepository.findById(cartId);

        if (cartToBeProcessed.isPresent()) {
            addedProducts.stream().forEach(p-> cartToBeProcessed.get().addProduct(p));
            cartRepository.save(cartToBeProcessed.get());
        }
        else throw new CartNotFoundException();
    }


    public void removeProductsFromCart(List<Product> productToBeRemoved, Long cartId) {

        Optional<Cart> cartToBeProcessed = cartRepository.findById(cartId);

        if (cartToBeProcessed.isPresent()) {
            productToBeRemoved.stream().forEach(p-> cartToBeProcessed.get().removeProduct(p));
            cartRepository.save(cartToBeProcessed.get());

        }
        else throw new CartNotFoundException();
    }

    public Order createOrderFromCart(Cart cart) {

        Order orderToBeReturned = new Order();

        orderToBeReturned.setOrderDate(LocalDate.now());

        orderToBeReturned.setNumber("ORD/" + cart.getId().toString() +
                "/" + orderToBeReturned.getOrderDate().getDayOfMonth() +
                "/" + orderToBeReturned.getOrderDate().getMonth() +
                "/" + orderToBeReturned.getOrderDate().getYear());

        cart.getProducts().keySet().stream().forEach(p-> orderToBeReturned.getOrderedProductsList().add(p));

        return orderToBeReturned;
    }


}
