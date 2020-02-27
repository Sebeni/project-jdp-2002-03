package com.kodilla.ecommercee.domain;

public final class GroupDto {
    private final Long id;
    private final String name;
    
    public GroupDto(final Long id, final String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
