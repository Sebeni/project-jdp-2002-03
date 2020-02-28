package com.kodilla.ecommercee.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public final class CartDto {

    private Long id;
    private String name;
    private List<ProductDto> products;

    public CartDto() {

    }

    public CartDto(final String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    @Column (unique = true)
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

    @OneToMany(
        targetEntity = ProductDto.class,
            mappedBy = "cart",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<ProductDto> getProducts() {
        return products;
    }

    private void setId(Long id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setProducts(List<ProductDto> products) {
        this.products = products;
    }
}
