package com.mm_cinema.booking.model.enumeration;

import com.mm_cinema.common_library.model.enumeration.PersistableEnum;
import lombok.Getter;

@Getter
public enum BookingStatus implements PersistableEnum {
    INACTIVE(0),
    ACTIVE(1);

    private final int value;

    BookingStatus(int value) {
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }

    public static BookingStatus fromCode(int value) {
        for (BookingStatus status : BookingStatus.values()) {
            if (status.getValue() == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid BookingStatus code: " + value);
    }
}