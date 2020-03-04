package com.kodilla.ecommercee.domain;


import java.util.List;

public final class OrderDto {
    private final Long id;
    private final List<String> orderedProductList;

    public OrderDto(final Long id, final List<String> orderedProductList) {
        this.id = id;
        this.orderedProductList = orderedProductList;
    }

    public Long getId() {
        return id;
    }

    public List<String> getOrderedProductList() {
        return orderedProductList;
    }

}
