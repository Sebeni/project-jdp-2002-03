package com.kodilla.ecommercee.domain;

import java.util.Set;

public class UserDto {
    private Long id;
    private String userName;
    private Set<Token> userToken;
    private boolean blocked;

    public UserDto(Long id, String userName, Set<Token> userToken, boolean blocked) {
        this.id = id;
        this.userName = userName;
        this.userToken = userToken;
        this.blocked = blocked;
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public Set<Token> getUserToken() {
        return userToken;
    }

    public boolean isBlocked() { return blocked; }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserToken(Set<Token> userToken) {
        this.userToken = userToken;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }
}
