package com.kodilla.ecommercee.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long id;

    private String description;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Order> orderList = new ArrayList<>();

    @ManyToOne
    private ProductGroup productGroup;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Cart> cartList = new ArrayList<>();

    public Product() {
    }

    public Product(Long id, String description, ProductGroup productGroup, List<Order> orderList, List<Cart> cartList) {
        this.id = id;
        this.description = description;
        this.productGroup = productGroup;
        this.orderList = orderList;
        this.cartList = cartList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public ProductGroup getProductGroup() {
        return productGroup;
    }

    public void setProductGroup(ProductGroup productGroup) {
        this.productGroup = productGroup;
    }

    public List<Cart> getCartList() {
        return cartList;
    }

    public void setCartList(List<Cart> cartList) {
        this.cartList = cartList;
    }
}


