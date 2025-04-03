package com.mm_cinema.common_library.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseStatus {
    StatusSuccess(1),
    StatusFailure(0);

    private final int value;
}
