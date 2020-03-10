package com.kodilla.ecommercee.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany
    private List<Cart> cart;

    public Product() {
    }

    public List<Cart> getCart() {
        return cart;
    }
}
