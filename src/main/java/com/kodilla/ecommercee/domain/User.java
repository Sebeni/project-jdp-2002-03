package com.kodilla.ecommercee.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long id;

    @NotNull
    private String userName;

    @NotNull
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Token> userToken;

    private boolean blocked;

    public User(Long id, String userName, Set<Token> userToken, boolean blocked) {
        this.id = id;
        this.userName = userName;
        this.userToken = userToken;
        this.blocked = blocked;
    }

    public User(String userName, Set<Token> userToken, boolean blocked) {
        this.userName = userName;
        this.userToken = userToken;
        this.blocked = blocked;
    }

    public User(Long id, String john, long l, boolean blocked) {
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

    public boolean isBlocked() {
        return blocked;
    }

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
