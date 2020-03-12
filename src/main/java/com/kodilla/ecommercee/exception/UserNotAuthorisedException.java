package com.kodilla.ecommercee.exception;

public class UserNotAuthorisedException extends RuntimeException {

    public UserNotAuthorisedException() {
        super("User hasn't been authorised.");
    }
}
