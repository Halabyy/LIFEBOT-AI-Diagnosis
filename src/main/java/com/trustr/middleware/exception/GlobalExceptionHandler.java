package com.trustr.middleware.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.trustr.middleware.dto.response.ErrorResponseDto;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(LifeBotException.class)
    public ResponseEntity<ErrorResponseDto> handleLifeBotException(LifeBotException ex) {
        return buildResponse(HttpStatus.SERVICE_UNAVAILABLE, "LifeBot Sensor Failure", ex.getMessage());
    }

    @ExceptionHandler(TrustrException.class)
    public ResponseEntity<ErrorResponseDto> handleTrustrException(TrustrException ex) {
        return buildResponse(HttpStatus.BAD_GATEWAY, "Trustr API Error", ex.getMessage());
    }

    @ExceptionHandler(UIDataException.class)
    public ResponseEntity<ErrorResponseDto> handleUIDataException(UIDataException ex) {
        return buildResponse(HttpStatus.BAD_REQUEST, "Invalid UI Input", ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleGenericException(Exception ex) {
        return buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Unexpected Error", ex.getMessage());
    }

    private ResponseEntity<ErrorResponseDto> buildResponse(HttpStatus status, String error, String message) {
        ErrorResponseDto errorResponse = new ErrorResponseDto(
                status.value(),
                error,
                message,
                LocalDateTime.now().toString()
        );
        return new ResponseEntity<>(errorResponse, status);
    }
}
