package com.kodilla.ecommercee.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table
public class Cart {

    @Id
    @NotNull
    @GeneratedValue
    @Column
    private Long id;

    @Column
    private String name;

    @OneToMany (
    )
    private List<ProductDto> products;

}
