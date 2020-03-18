package com.kodilla.ecommercee.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Map;

@Entity(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long id;

    @NotNull
    @Column(updatable = false)
    private String number;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable
    @MapKeyJoinColumn
    @Column
    private Map<Product, Integer> products;

    @Column(updatable = false)
    private LocalDate orderDate;
    
    @ManyToOne
    private User user;
    
    public Order() {
    }
    
    public Order(Cart cart) {
        this(cart.getProducts(), cart.getUser());
    }
    
    public Order(Map<Product, Integer> products, User user) {
        this.products = products;
        this.user = user;
        this.orderDate = LocalDate.now();
        this.number = System.currentTimeMillis() + user.getId().toString();
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

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
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
