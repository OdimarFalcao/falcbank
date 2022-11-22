package com.falcbank.falcbank.handler;

import com.falcbank.falcbank.exception.BadRequestException;
import com.falcbank.falcbank.exception.ExceptionDetails;
import com.falcbank.falcbank.exception.GenericConflictException;
import com.falcbank.falcbank.exception.GenericExceptionNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionDetails>BadRequestException(BadRequestException badRequestException) {
        return new ResponseEntity<>(
                ExceptionDetails.builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .title("BadRequestException, check the documentation")
                        .details(badRequestException.getMessage())
                        .developerMessage(badRequestException.getClass().getName())
                        .build(), HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(GenericExceptionNotFound.class)
    public ResponseEntity<ExceptionDetails>NotFoundException(GenericExceptionNotFound ex){
        return new ResponseEntity<>(
                ExceptionDetails.builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.NOT_FOUND.value())
                        .title("BadRequestException, check the documentation")
                        .details(ex.getMessage())
                        .developerMessage(ex.getMessage())
                        .build(),HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(GenericConflictException.class)
    public ResponseEntity<ExceptionDetails>ConflictException(GenericConflictException ex){
        return new ResponseEntity<>(
                ExceptionDetails.builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.NOT_FOUND.value())
                        .title("BadRequestException, check the documentation")
                        .details(ex.getMessage())
                        .developerMessage(ex.getMessage())
                        .build(),HttpStatus.NOT_FOUND);

    }
}
