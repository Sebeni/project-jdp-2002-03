package com.kodilla.ecommercee.domain;

<<<<<<< HEAD
=======

import lombok.AllArgsConstructor;
import lombok.Getter;

>>>>>>> 5442fe577dcaa07a53b9d4f5bd035de9b4ec7b05
import java.util.ArrayList;
import java.util.List;

public class ProductDto {

    private Long id;
    private String description;
    private Group group;
    private List<Order> orderList = new ArrayList<>();
    private List<Cart> cartList = new ArrayList<>();

<<<<<<< HEAD
    public ProductDto() {
    }

    public ProductDto(Long id, String description, Group group, List<Order> orderList, List<Cart> cartList) {
        this.id = id;
        this.description = description;
        this.group = group;
        this.orderList = orderList;
        this.cartList = cartList;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Group getGroup() {
        return group;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public List<Cart> getCartList() {
        return cartList;
    }
=======

>>>>>>> 5442fe577dcaa07a53b9d4f5bd035de9b4ec7b05
}
