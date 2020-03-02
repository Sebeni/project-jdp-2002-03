package com.kodilla.ecommercee.domain;

public class GroupStub implements GroupInterface {
    private Long id;
    private String name;

    public GroupStub(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public GroupStub() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
