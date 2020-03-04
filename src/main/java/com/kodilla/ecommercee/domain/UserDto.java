package com.kodilla.ecommercee.domain;

public final class UserDto {
    private final Long id;
    private final String userName;
    private final String lastname;
    private final boolean blocked;

    public UserDto(final Long id, final String userName, final String lastname, final boolean blocked) {
        this.id = id;
        this.userName = userName;
        this.lastname = lastname;
        this.blocked = blocked;
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getLastname() {
        return lastname;
    }

    public boolean isBlocked() {
        return blocked;
    }
}
