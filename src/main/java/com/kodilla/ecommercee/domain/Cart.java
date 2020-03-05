package com.kodilla.ecommercee.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table
public class Cart {
    @Id
    @NotNull
    @GeneratedValue
    @Column
    private Long id;

    private String name;

    @OneToMany(
            targetEntity = Product.class,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private Set<Product> products;


}
