package com.kodilla.ecommercee.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long id;

    @ManyToOne
    private User user;

    private LocalDate orderDate;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable
    @MapKeyJoinColumn
    @Column
    private Map<Product, Integer> products;

    public Order() {
    }

    public Order(Cart cart) {
        this(null, cart.getProducts(), cart.getUser());
    }

    public Order(Long id, Map<Product, Integer> products, User user) {
        this.id = id;
        this.products = new HashMap<>(products);
        this.user = user;
        this.orderDate = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public User getUser() {
        return user;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
}