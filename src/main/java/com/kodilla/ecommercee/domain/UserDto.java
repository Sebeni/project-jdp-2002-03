package com.kodilla.ecommercee.domain;

public class UserDto {
    private String userName;
    private String lastname;
    private Long userId;
    private boolean blocked;

    public UserDto(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getLastname() {
        return lastname;
    }

    public Long getUserId() {
        return userId;
    }

    public boolean isBlocked() {
        return blocked;
    }
}
