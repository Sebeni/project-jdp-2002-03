package com.kodilla.ecommercee.domain;

<<<<<<< HEAD
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
    private String lastname;

    @NotNull
    private boolean blocked;

    public User(String userName, String lastname, boolean blocked) {
        this.userName = userName;
        this.lastname = lastname;
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

    public String getLastname() {
        return lastname;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setId(Long userId) {
        this.id = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }
=======
public class User {
>>>>>>> master
}
