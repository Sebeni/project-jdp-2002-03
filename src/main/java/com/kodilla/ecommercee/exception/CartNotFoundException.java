package com.kodilla.ecommercee.exception;

public class CartNotFoundException extends RuntimeException {

    public CartNotFoundException() {
        super("Cart with given id does not exist");
    }
}
