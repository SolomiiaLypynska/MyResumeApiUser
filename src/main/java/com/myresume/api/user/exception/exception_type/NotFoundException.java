package com.myresume.api.user.exception.exception_type;

import com.myresume.api.user.exception.CustomValidationException;

public class NotFoundException extends CustomValidationException {
    public NotFoundException(String customMessage) {
        super(customMessage);
    }
}
