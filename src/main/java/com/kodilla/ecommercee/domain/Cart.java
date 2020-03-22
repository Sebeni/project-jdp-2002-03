package com.kodilla.ecommercee.domain;


import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long id;

    @ElementCollection (fetch = FetchType.EAGER)
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
        if (products.containsKey(productToBeAdded)) {
            Integer adjustedQty = products.get(productToBeAdded) + 1;
            products.replace(productToBeAdded, adjustedQty);
        } else {
            products.put(productToBeAdded, 1);
        }
    }

    public void removeProduct(Product productToBeRemoved) {
        if (products.containsKey(productToBeRemoved)) {
            Integer currentQty = products.get(productToBeRemoved);
            if (currentQty > 1) {
                currentQty--;
                products.replace(productToBeRemoved, currentQty);
            } else {
                products.remove(productToBeRemoved);
            }
        }
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }
}
