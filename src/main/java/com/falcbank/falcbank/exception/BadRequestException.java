package com.falcbank.falcbank.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class BadRequestException extends RuntimeException{
    public BadRequestException(String message){
        super(message);
    }
}
