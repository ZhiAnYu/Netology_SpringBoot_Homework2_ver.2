package ru.netology.RestHomework2_my.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler(InvalidCredentialException.class)
    public ResponseEntity<String> handleInvalidCredentials(InvalidCredentialException exc) {
        // HTTP-статус 400 и тело в виде сообщения из exception
        return ResponseEntity.status(400).body(exc.getMessage());
    }

    @ExceptionHandler(UnauthorizedUserException.class)
    public ResponseEntity<String> handleUnauthorizedUser (UnauthorizedUserException exc){
        //HTTP-статус 401 и тело в виде сообщения из exception + лог в консоль
        System.out.println(exc.getMessage());
        return ResponseEntity.status(401).body(exc.getMessage());
    }
}
