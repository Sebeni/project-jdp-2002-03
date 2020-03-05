package com.kodilla.ecommercee.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Cart {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    private String name;

    @OneToMany(
            targetEntity = Product.class,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private Set<Product> products;

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

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
