package com.kodilla.ecommercee.domain;

import java.util.ArrayList;
import java.util.List;

public class CartDto {

    private Long id;
    private String name;
    private List<ProductDto> products;

    public CartDto(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<ProductDto> getProducts() {
        return products;
    }
}
