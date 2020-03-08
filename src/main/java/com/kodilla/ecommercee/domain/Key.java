package com.kodilla.ecommercee.domain;

import java.time.LocalDateTime;

public class Key {
    private Long value;
    private LocalDateTime validFrom;
    private LocalDateTime getValidTo;

    public Key(Long value, LocalDateTime validFrom, LocalDateTime getValidTo) {
        this.value = value;
        this.validFrom = validFrom;
        this.getValidTo = getValidTo;
    }
}
