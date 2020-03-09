package com.kodilla.ecommercee.domain;

import javax.persistence.*;
import java.util.Map;

@Entity
public class Cart {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToMany
    @MapKeyColumn
    private Map<Integer,Product> products;

    @OneToOne
    private User user;

    public Cart() {
    }

    public Cart(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public Map<Integer, Product> getProducts() {
        return products;
    }

    public User getUser() {
        return user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setProducts(Map<Integer, Product> products) {
        this.products = products;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
