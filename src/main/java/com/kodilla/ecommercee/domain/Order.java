package com.kodilla.ecommercee.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "product_order_list")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long id;

    @NotNull
    private String number;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    private LocalDate orderDate;

    @ManyToMany
    private List<Product> orderedProductsList = new ArrayList<>();

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public List<Product> getOrderedProductsList() {
        return orderedProductsList;
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

    public void setOrderedProductsList(List<Product> orderedProductsList) {
        this.orderedProductsList = orderedProductsList;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
}
