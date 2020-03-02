package com.kodilla.ecommercee.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public final class CartDto {

    private final Long id;
    private final String name;
    private final List<ProductDto> products;

    public CartDto(final Long id, final String name, final List<ProductDto> products) {
        this.id = id;
        this.name = name;

        ProductDto tmpProduct = new ProductDto();
        List<ProductDto> tmpProductList = new ArrayList<>();

        Iterator<ProductDto> iterator = products.iterator();
        while(iterator.hasNext()) {
            tmpProduct = iterator.next();
            tmpProductList.add(tmpProduct);
        }
        this.products = tmpProductList;

    }

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public List<ProductDto> getProducts() {
        return (List<ProductDto>) new ArrayList<>(products);
    }

}
