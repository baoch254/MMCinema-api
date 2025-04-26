package com.mm_cinema.employee.model.enumeration;

import com.mm_cinema.common_library.model.enumeration.PersistableEnum;
import lombok.Getter;

@Getter
public enum Gender implements PersistableEnum {
    MALE(1),
    FEMALE(2),
    OTHER(3);

    private final int value;

    Gender(int value) {
        this.value = value;
    }
    @Override
    public int getValue() {
        return value;
    }

    public static Gender fromCode(int code) {
        for (Gender gender : values()) {
            if (gender.getValue() == code) {
                return gender;
            }
        }
        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
