package com.kodilla.ecommercee.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long id;

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
>>>>>>> 2c51280f34191a5052db937b24e05e87dd276579
    private String name;

    private String description;

    private BigDecimal price;

    @ManyToOne
    private Group group;

    public Product() {
    }

    public Product(Long id, String name, String description, BigDecimal price, Group group) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.group = group;
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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
<<<<<<< HEAD
=======
>>>>>>> cb330760f240c4a83c360f9fe4a4897ad66c41df
>>>>>>> 2c51280f34191a5052db937b24e05e87dd276579
}
