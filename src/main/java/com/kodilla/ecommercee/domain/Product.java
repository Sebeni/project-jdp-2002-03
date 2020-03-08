package com.kodilla.ecommercee.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long id;

    private String description;

    @ManyToMany
    private List<Order> orderList = new ArrayList<>();

    @ManyToOne
    private Group group;

    @ManyToMany
    private List<Cart> cartList = new ArrayList<>();

    public Product() {
    }

    public Product(Long id, String description, Group group, List<Order> orderList, List<Cart> cartList) {
        this.id = id;
        this.description = description;
        this.group = group;
        this. orderList = orderList;
        this.cartList = cartList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public List<Cart> getCartList() {
        return cartList;
    }

    public void setCartList(List<Cart> cartList) {
        this.cartList = cartList;
    }
}
