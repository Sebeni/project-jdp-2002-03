package com.kodilla.ecommercee.domain;

import java.time.LocalDateTime;

public class Key {
    private Long value;
    private LocalDateTime validFrom;
    private LocalDateTime validTo;

    public Key(Long value, LocalDateTime validFrom, LocalDateTime validTo) {
        this.value = value;
        this.validFrom = validFrom;
        this.validTo = validTo;
    }
}
