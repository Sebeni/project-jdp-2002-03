package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class ProductDto {

    private Long id;
    private String description;
    private Group group;
    private List<Order> orderList = new ArrayList<>();
    private List<Cart> cartList = new ArrayList<>();

}
