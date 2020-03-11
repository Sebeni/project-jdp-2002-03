package com.kodilla.ecommercee.domain;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Cart {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ElementCollection
    @CollectionTable
    @MapKeyJoinColumn
    @Column
    private Map<Product, Integer> products;

    @OneToOne
    private User user;

    public Cart() {
        this.products = new HashMap<>();
    }

    public Cart(User user) {
        this.user = user;
        this.products = new HashMap<>();
    }


    public void addProduct(Product productToBeAdded) {

        Integer qty = 0;

        if (products.containsKey(productToBeAdded)) {
            qty = products.get(productToBeAdded)+1;
            products.replace(productToBeAdded,qty);
        }
        else {
            products.put(productToBeAdded,1);
        }
    }

    public void removeProduct(Product productToBeRemoved) {

        Integer qty =0;

        if (products.containsKey(productToBeRemoved)) {
            qty = products.get(productToBeRemoved)-1;
            products.replace(productToBeRemoved, qty);
        }

    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    private Map<Product, Integer> getProducts() {
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


    private void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
