package com.kodilla.ecommercee.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Product {

    @Id
    @NotNull
    @GeneratedValue
    @Column
    private Long id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn
    private Cart cart;


}
