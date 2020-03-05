package com.kodilla.ecommercee.domain;

import javax.persistence.*;

@Entity
@Table
public class Product {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @ManyToOne
    @JoinColumn
    private Cart cart;


}
