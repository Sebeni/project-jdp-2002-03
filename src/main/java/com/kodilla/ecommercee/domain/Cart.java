package com.kodilla.ecommercee.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
public class Cart {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    private BigDecimal price;

    @OneToMany(
            targetEntity = Product.class,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private Set<Product> products;

    private Long groupId;

    public Cart() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }
}
