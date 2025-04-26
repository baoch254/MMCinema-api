package com.mm_cinema.cinema.model.enumeration;

import com.mm_cinema.common_library.model.enumeration.PersistableEnum;
import lombok.Getter;

@Getter
public enum SeatStatus implements PersistableEnum {
    AVAILABLE(0),
    BOOKED(1),
    PENDING_PAYMENT(2);

    private final int value;

    SeatStatus(int value) {
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }

    public static SeatStatus fromCode(int value) {
        for (SeatStatus status : SeatStatus.values()) {
            if (status.getValue() == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid SeatStatus code: " + value);
    }
}