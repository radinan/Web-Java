package com.fmi.merchandise.validation.error_dto;

import org.springframework.http.HttpStatus;

public class ApiErrorDto {
    private final HttpStatus status;
    private final String message;

    public ApiErrorDto(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

}
