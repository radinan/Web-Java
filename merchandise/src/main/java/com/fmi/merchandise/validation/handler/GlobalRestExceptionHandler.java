package com.fmi.merchandise.validation.handler;

import com.fmi.merchandise.validation.error_dto.ApiErrorDto;
import com.fmi.merchandise.validation.exception.ApiBadRequestException;
import com.fmi.merchandise.validation.exception.ApiResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalRestExceptionHandler extends ResponseEntityExceptionHandler {

    //404
    @ExceptionHandler(value = {ApiResourceNotFoundException.class})
    public final ResponseEntity<Object> handleNotFoundRequest(final ApiResourceNotFoundException ex,
                                                              final WebRequest request) {
        final String message = ex.getMessage();
        final ApiErrorDto apiError = new ApiErrorDto(HttpStatus.NOT_FOUND, message);
        return handleExceptionInternal(ex, apiError, new HttpHeaders(), apiError.getStatus(), request);
    }

    //400
    @ExceptionHandler(value = {ApiBadRequestException.class})
    public final ResponseEntity<Object> handleNotFoundRequest(final ApiBadRequestException ex,
                                                              final WebRequest request) {
        final String message = ex.getMessage();
        final ApiErrorDto apiError = new ApiErrorDto(HttpStatus.BAD_REQUEST, message);
        return handleExceptionInternal(ex, apiError, new HttpHeaders(), apiError.getStatus(), request);
    }

    //500
    @ExceptionHandler(value = {RuntimeException.class})
    public final ResponseEntity<Object> handleNotFoundRequest(final RuntimeException ex,
                                                              final WebRequest request) {
        final String message = "Oops, something went wrong.";
        final ApiErrorDto apiError = new ApiErrorDto(HttpStatus.INTERNAL_SERVER_ERROR, message);
        return handleExceptionInternal(ex, apiError, new HttpHeaders(), apiError.getStatus(), request);
    }
}
