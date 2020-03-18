package com.kodilla.ecommercee.domain;

import java.util.Map;


public class CartDto {

    private Long id;
    private UserDto userDto;
    private Map<ProductDto, Integer> products;

    public CartDto() {
    }

    public CartDto(Long id, UserDto userDto, Map<ProductDto, Integer> products) {
        this.id = id;
        this.userDto = userDto;
        this.products = products;
    }

    public Long getId() {
        return id;
    }
    
    public UserDto getName() {
        return userDto;
    }
    
    public Map<ProductDto, Integer> getProducts() {
        return products;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(UserDto name) {
        this.userDto = name;
    }

    public void setProducts(Map<ProductDto, Integer> products) {
        this.products = products;
    }
}