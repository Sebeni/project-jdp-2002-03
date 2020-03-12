package com.kodilla.ecommercee.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        super("User hasn't been found.");
    }
}
