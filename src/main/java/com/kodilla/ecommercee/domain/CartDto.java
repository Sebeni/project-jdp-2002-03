package com.kodilla.ecommercee.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public final class CartDto {

    private final Long id;
    private final String name;
    private final List<ProductDto> products;

    public CartDto(final Long id, final String name, final List<ProductDto> products) {
        this.id = id;
        this.name = name;
        this.products = new ArrayList<>();
        this.products.addAll(products);

    }

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public List<ProductDto> getProducts() {
        return Collections.unmodifiableList(products);
    }

}
