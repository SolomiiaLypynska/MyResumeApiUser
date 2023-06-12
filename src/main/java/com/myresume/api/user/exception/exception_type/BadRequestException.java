package com.myresume.api.user.exception.exception_type;

import com.myresume.api.user.exception.CustomValidationException;

public class BadRequestException extends CustomValidationException {
    public BadRequestException(String customMessage) {
        super(customMessage);
    }
}
