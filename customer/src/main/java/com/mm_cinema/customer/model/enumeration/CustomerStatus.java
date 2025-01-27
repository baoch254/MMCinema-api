package com.mm_cinema.customer.model.enumeration;

import lombok.Getter;

@Getter
public enum CustomerStatus {
    INACTIVE(0),
    ACTIVE(1);

    private final int value;

    CustomerStatus(int value) {
        this.value = value;
    }
}