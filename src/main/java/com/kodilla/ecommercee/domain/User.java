package com.kodilla.ecommercee.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long id;

    @NotNull
    private String userName;

    @NotNull
    private String lastname;

    @NotNull
    private boolean blocked;

    @OneToMany(
            targetEntity = Order.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Order> orders = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Cart cart;

    public User(String userName, String lastname, boolean blocked) {
        this.userName = userName;
        this.lastname = lastname;
        this.blocked = blocked;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getLastname() {
        return lastname;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public Cart getCart() {
        return cart;
    }

    public void setId(Long userId) {
        this.id = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
