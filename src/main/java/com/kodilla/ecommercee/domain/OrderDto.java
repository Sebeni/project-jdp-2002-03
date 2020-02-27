package com.kodilla.ecommercee.domain;

import java.util.ArrayList;
import java.util.List;

public class OrderDto {
    private Long id;
    private List<String> orderedProductList;

    public OrderDto(Long id, List<String> orderedProductList) {
        this.id = id;
        this.orderedProductList = orderedProductList;
    }

    public Long getId() {
        return id;
    }

    public List<String> getOrderedProductList() {
        return orderedProductList;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
