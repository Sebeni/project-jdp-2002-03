package com.kodilla.ecommercee.domain;

public class ProductDto {

    private Long id;
    private String description;
    private Group group;

    public ProductDto() {
    }

    public ProductDto(Long id, String description, Group group) {
        this.id = id;
        this.description = description;
        this.group = group;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Group getGroup() {
        return group;
    }

}

