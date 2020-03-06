package com.kodilla.ecommercee.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Cart {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToMany
    private Set<Product> products;

    @OneToOne
    private User user;

    public Cart() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public Set<Product> getProducts() {
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


    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
