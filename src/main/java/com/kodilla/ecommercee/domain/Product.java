package com.kodilla.ecommercee.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(unique = true)
    private Long id;

    @Column
    private String description;

    //@ManyToMany(cascade = CascadeType.ALL, mappedBy = "products")
    //private List<Order> orderList = new ArrayList<>();

    //@ManyToOne
    //private Group group;

    //private List<Cart> cartList = new ArrayList<>();

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //add all args constructor when Group, Order, Cart ready + getters & setters for all

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
