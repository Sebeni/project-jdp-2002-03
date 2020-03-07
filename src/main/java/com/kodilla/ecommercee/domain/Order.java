package com.kodilla.ecommercee.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String number;

    @NotNull
    @ManyToOne(
            //cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDate orderDate;

    @ManyToMany
    @JoinTable(
            name = "JOIN_PRODUCTS_ORDERS",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> orderedProductsList = new ArrayList<>();

    public Order() {
    }

    public Order(String number, Cart cart, LocalDate orderDate) {
        this.number = number;
        this.user = cart.getUser();
        this.orderDate = orderDate;
        this.orderedProductsList = cart.getProductsList();
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

    private void setId(Long id) {
        this.id = id;
    }

    private void setOrderedProductsList(List<Product> orderedProductsList) {
        this.orderedProductsList = orderedProductsList;
    }

    private void setNumber(String number) {
        this.number = number;
    }

    private void setUser(User user) {
        this.user = user;
    }

    private void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
}
