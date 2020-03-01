package com.kodilla.ecommercee.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Long id;

    @NotNull
    @Column(name = "number")
    private String number;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    private LocalDate orderDate;

    @ManyToMany(
            cascade = CascadeType.ALL,
            mappedBy = "orders")
    private List<Product> orderedProductsList = new ArrayList<>();

    public Order() {
    }

    public Order(String number, User user, LocalDate orderDate) {
        this.number = number;
        this.user = user;
        this.orderDate = orderDate;
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
