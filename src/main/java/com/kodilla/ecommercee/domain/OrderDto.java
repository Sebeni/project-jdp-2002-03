package com.kodilla.ecommercee.domain;

public class OrderDto {
    private Long id;
    private String name;

    public OrderDto(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
