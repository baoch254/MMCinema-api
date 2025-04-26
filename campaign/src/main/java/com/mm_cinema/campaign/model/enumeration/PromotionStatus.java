package com.mm_cinema.campaign.model.enumeration;

import com.mm_cinema.common_library.model.enumeration.PersistableEnum;
import lombok.Getter;

@Getter
public enum PromotionStatus implements PersistableEnum {
    INACTIVE(0),
    ACTIVE(1);

    private final int value;

    PromotionStatus(int value) {
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }

    public static PromotionStatus fromCode(int value) {
        for (PromotionStatus status : PromotionStatus.values()) {
            if (status.getValue() == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid PromotionStatus code: " + value);
    }
}