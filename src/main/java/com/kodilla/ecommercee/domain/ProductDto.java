package com.kodilla.ecommercee.domain;

import java.util.ArrayList;
import java.util.List;

public class ProductDto {

    private Long id;
    private String description;
    private ProductGroup productGroup;
    private List<Order> orderList = new ArrayList<>();
    private List<Cart> cartList = new ArrayList<>();

    public ProductDto() {
    }

    public ProductDto(Long id, String description, ProductGroup productGroup, List<Order> orderList, List<Cart> cartList) {
        this.id = id;
        this.description = description;
        this.productGroup = productGroup;
        this.orderList = orderList;
        this.cartList = cartList;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public ProductGroup getProductGroup() {
        return productGroup;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public List<Cart> getCartList() {
        return cartList;
    }
}


