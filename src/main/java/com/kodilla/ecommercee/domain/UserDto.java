package com.kodilla.ecommercee.domain;

import java.util.Set;

public class UserDto {
    private Long id;
    private String userName;
    private Set<Key> userKey;
    private boolean blocked;

    public UserDto(Long id, String userName, Set<Key> userKey, boolean blocked) {
        this.id = id;
        this.userName = userName;
        this.userKey = userKey;
        this.blocked = blocked;
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public Set<Key> getUserKey() {
        return userKey;
    }

    public boolean isBlocked() { return blocked; }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserKey(Set<Key> userKey) {
        this.userKey = userKey;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }
}
