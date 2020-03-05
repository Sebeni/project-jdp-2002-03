package com.kodilla.ecommercee.domain;

public final class UserDto {
    private final Long userId;
    private final String userName;
    private final String lastname;
    private final boolean blocked;

    public UserDto(final Long userId, final String userName, final String lastname, final boolean blocked) {
        this.userId = userId;
        this.userName = userName;
        this.lastname = lastname;
        this.blocked = blocked;
    }

    public Long getUserId() {
        return userId;
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
