package com.mm_cinema.common_library.exception;

import com.mm_cinema.common_library.utils.MessagesUtils;

public class ResourceExistedException extends RuntimeException {
    private String message;

    public ResourceExistedException(String errorCode, Object... var2) {
        this.message = MessagesUtils.getMessage(errorCode, var2);
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
