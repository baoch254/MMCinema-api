package com.mm_cinema.employee.model.enumeration;

import com.mm_cinema.common_library.model.enumeration.PersistableEnum;
import lombok.Getter;

@Getter
public enum EmployeeStatus implements PersistableEnum {
    INACTIVE(0),
    ACTIVE(1);

    private final int value;

    EmployeeStatus(int value) {
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }

    public static EmployeeStatus fromCode(int value) {
        for (EmployeeStatus status : EmployeeStatus.values()) {
            if (status.getValue() == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid EmployeeStatus code: " + value);
    }
}