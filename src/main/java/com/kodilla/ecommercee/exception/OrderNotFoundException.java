package com.kodilla.ecommercee.exception;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException() {
        super("Order with given id does not exist");
    }
}
