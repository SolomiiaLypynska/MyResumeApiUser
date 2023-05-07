package com.myresume.api.user.exception;

import lombok.Getter;

@Getter
public class CustomValidationException extends RuntimeException {
    private String customMessage = "";

    public CustomValidationException(String customMessage) {
        this.customMessage = customMessage;
    }
}
