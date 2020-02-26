package com.kodilla.ecommercee.domain;

public class ProductDto {
    private Long id;
    private String name;

    public ProductDto(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
