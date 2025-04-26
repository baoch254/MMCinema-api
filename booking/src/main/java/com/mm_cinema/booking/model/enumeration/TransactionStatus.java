package com.mm_cinema.booking.model.enumeration;

import com.mm_cinema.common_library.model.enumeration.PersistableEnum;
import lombok.Getter;

@Getter
public enum TransactionStatus implements PersistableEnum {
    INACTIVE(0),
    ACTIVE(1);

    private final int value;

    TransactionStatus(int value) {
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }

    public static TransactionStatus fromCode(int value) {
        for (TransactionStatus status : TransactionStatus.values()) {
            if (status.getValue() == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid TransactionStatus code: " + value);
    }
}