package com.dev.jt.httpcodes.config;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dev.jt.httpcodes.dto.ApiErrorResponse;
import com.dev.jt.httpcodes.exception.EmailAlreadyExistException;

import jakarta.servlet.http.HttpServletRequest;


// @RestControllerAdvice // versiones mas reciente y modo grafico.
@ControllerAdvice //Es mas general
public class GlobalExceptionHandler {

    // @ExceptionHandler(EmailAlreadyExistException.class)
    // public ResponseEntity<String> handleEmailAlreadyExistException( EmailAlreadyExistException exception) {
    //     return  ResponseEntity.status(HttpStatus.CONFLICT)
    //         .body("El correo electronico ya existe en la lista de usuarios");
    // }

    // Usando DTO.
    @ExceptionHandler(EmailAlreadyExistException.class)
    public ResponseEntity<ApiErrorResponse> handleEmailAlreadyExistException( EmailAlreadyExistException exception, HttpServletRequest request) {
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body( new ApiErrorResponse(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST,
                "El correo electronico ya existe en la lista de usuarios",
                request.getRequestURI()));
    }


    //creamos funciones para manejar exceptions generics.
    // @ExceptionHandler(Exception.class)
    // public ResponseEntity<String> handleException( Exception exception) {
    //     return  ResponseEntity.internalServerError()
    //         .body(exception.getMessage());
    // }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleException( Exception exception, HttpServletRequest request) {
        return  ResponseEntity.internalServerError()
            .body(new ApiErrorResponse(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST,
                exception.getMessage(),
                request.getRequestURI()));
    }


}
