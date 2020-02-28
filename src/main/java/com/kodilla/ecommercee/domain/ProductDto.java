package com.kodilla.ecommercee.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class ProductDto {
    private Long id;
    private String name;
    private CartDto cart;

    public ProductDto() {
    }

    public ProductDto(String name) {
        this.name = name;
    }

    @Column(unique = true)
    @Id
    @NotNull
    @GeneratedValue
    public Long getId() {
        return id;
    }

    @Column
    public String getName() {
        return name;
    }

    @ManyToOne
    @JoinColumn
    public CartDto getCart() {
        return cart;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCart(CartDto cart) {
        this.cart = cart;
    }
}
