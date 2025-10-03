package com.project.exceptions;

import lombok.Getter;

@Getter
public enum ErrorCode {
    PRICE_NOT_FOUND("ERR01");

    private final String error;

    ErrorCode(String errorCode) {
        this.error = errorCode;
    }
}
