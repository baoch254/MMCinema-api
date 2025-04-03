package com.mm_cinema.common_library.exception;

import com.mm_cinema.common_library.utils.MessagesUtils;

public class InternalServerErrorException extends RuntimeException {

    private final String message;

    public InternalServerErrorException(String errorCode, Object... var2) {
        this.message = MessagesUtils.getMessage(errorCode, var2);
    }

    @Override
    public String getMessage() {
        return message;
    }
}
