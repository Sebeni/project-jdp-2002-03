package com.kodilla.ecommercee.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long id;

    @NotNull
    private String userName;

    @NotNull
    private Long userKey;

    @NotNull
    private boolean blocked;

    public User(Long id, String userName, Long userKey, boolean blocked) {
        this.id = id;
        this.userName = userName;
        this.userKey = userKey;
        this.blocked = blocked;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public Long getUserKey() {
        return userKey;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserKey(Long userKey) {
        this.userKey = userKey;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }
}
