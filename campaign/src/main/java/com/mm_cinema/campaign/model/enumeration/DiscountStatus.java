package com.mm_cinema.campaign.model.enumeration;

import com.mm_cinema.common_library.model.enumeration.PersistableEnum;
import lombok.Getter;

@Getter
public enum DiscountStatus implements PersistableEnum {
    INACTIVE(0),
    ACTIVE(1);

    private final int value;

    DiscountStatus(int value) {
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }

    public static DiscountStatus fromCode(int value) {
        for (DiscountStatus status : DiscountStatus.values()) {
            if (status.getValue() == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid DiscountStatus code: " + value);
    }
}