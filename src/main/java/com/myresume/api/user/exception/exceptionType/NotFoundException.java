package com.myresume.api.user.exception.exceptionType;

import com.myresume.api.user.exception.CustomValidationException;

public class NotFoundException extends CustomValidationException {
    public NotFoundException(String customMessage) {
        super(customMessage);
    }
}
