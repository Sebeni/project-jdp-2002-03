package com.kodilla.ecommercee.domain;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Cart cart;


}
