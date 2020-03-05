package com.kodilla.ecommercee.domain;

import javax.persistence.*;

@Entity
@Table
public class Product {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn
    private Cart cart;


}
