package com.kodilla.ecommercee.domain;

import java.util.List;


public class CartDto {

    private Long id;
    private List<Product> products;

    public CartDto() {
    }

    public CartDto(List<Product> products) {
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public List<Product> getProducts() {
        return products;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}