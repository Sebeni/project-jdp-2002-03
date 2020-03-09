package com.kodilla.ecommercee.exception;

public class GroupNotFoundException extends Exception {

    public GroupNotFoundException() {
        super("Group with given id does not exist");
    }
}
