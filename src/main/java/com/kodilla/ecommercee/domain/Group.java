package com.kodilla.ecommercee.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Group {
    
    @Id
    @GeneratedValue
    private Long id;
    
    private String name;

    public Group(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public Group() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
