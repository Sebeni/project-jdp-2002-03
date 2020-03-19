package com.kodilla.ecommercee.domain;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class OrderDto {
    private Long id;
    private String number;
    private List<Product> products;
    private LocalDate orderDate;
    private User user;

    public OrderDto(Long id, String number, List<Product> products, LocalDate orderDate, User user) {
        this.id = id;
        this.number = number;
        this.products = products;
        this.orderDate = orderDate;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}