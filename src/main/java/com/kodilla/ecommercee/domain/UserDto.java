package com.kodilla.ecommercee.domain;

public class UserDto {
    private Long id;
    private String userName;
    private String lastname;
    private boolean blocked;

    public UserDto(Long id, String userName, String lastname, boolean blocked) {
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
