package com.mm_cinema.customer.model.enumeration;

import lombok.Getter;

@Getter
public enum Gender {
    MALE(1),
    FEMALE(2),
    OTHER(3);

    private final int value;

    Gender(int value) {
        this.value = value;
    }
}
