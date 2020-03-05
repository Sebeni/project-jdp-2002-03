package com.kodilla.ecommercee.domain;

import org.springframework.stereotype.Component;

import java.util.List;


public class CartDto {

    private Long id;
    private String name;
    private List<ProductDto> products;

    public CartDto() {
    }

    public CartDto(Long id, String name, List<ProductDto> products) {
        this.id = id;
        this.name = name;
        this.products = products;
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


    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProducts(List<ProductDto> products) {
        this.products = products;
    }
}
