package com.kodilla.ecommercee.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Key {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long id;

    @NotNull
    private Long value;

    @NotNull
    private LocalDateTime validFrom;

    @NotNull
    private LocalDateTime validTo;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    public Key(Long value, LocalDateTime validFrom, LocalDateTime validTo) {
        this.value = value;
        this.validFrom = validFrom;
        this.validTo = validTo;
    }

    public Key() {
    }

    public Long getValue() {
        return value;
    }

    public LocalDateTime getValidFrom() {
        return validFrom;
    }

    public LocalDateTime getValidTo() {
        return validTo;
    }

    public User getUser() {
        return user;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public void setValidFrom(LocalDateTime validFrom) {
        this.validFrom = validFrom;
    }

    public void setValidTo(LocalDateTime validTo) {
        this.validTo = validTo;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
