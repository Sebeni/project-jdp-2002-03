package com.kodilla.ecommercee.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Cart {
    @Id
    @NotNull
    @GeneratedValue
    @Column
    private Long id;

}
