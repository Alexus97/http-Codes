package com.dev.jt.httpcodes.config;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dev.jt.httpcodes.dto.ApiErrorResponse;
import com.dev.jt.httpcodes.exception.AlreadyExistException;
import com.dev.jt.httpcodes.exception.EmailAlreadyExistException;
import com.dev.jt.httpcodes.exception.MissingValuesException;
import com.dev.jt.httpcodes.exception.UserNotFoundException;

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
    public ResponseEntity<ApiErrorResponse<String>> handleEmailAlreadyExistException( EmailAlreadyExistException exception, HttpServletRequest request) {
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body( new ApiErrorResponse<String>(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST,
                "El correo electronico ya existe en la lista de usuarios",
                request.getRequestURI()));
    }


    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiErrorResponse<String>> handleUserNotFoundException( UserNotFoundException exception, HttpServletRequest request) {
        return  ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body( new ApiErrorResponse<String>(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND,
                exception.getMessage(),
                request.getRequestURI()));
    }

    @ExceptionHandler(MissingValuesException.class)
    public ResponseEntity<ApiErrorResponse<String>> handleMisssingValuesException( MissingValuesException exception, HttpServletRequest request) {
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body( new ApiErrorResponse<String>(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST,
                exception.getMessage(),
                request.getRequestURI()));
    }


    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<ApiErrorResponse<String>> handleAlreadyExistException( AlreadyExistException exception, HttpServletRequest request) {
        return  ResponseEntity.status(HttpStatus.CONFLICT)
            .body( new ApiErrorResponse<String>(
                LocalDateTime.now(),
                HttpStatus.CONFLICT,
                exception.getMessage(),
                request.getRequestURI()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorResponse<List<String>>> handleMethodArgumentNotValidException( MethodArgumentNotValidException exception, HttpServletRequest request) {
        
        var message = exception.getAllErrors().stream()
            .map(e -> e.getDefaultMessage())
            //.collect(Collectors.joining(";")); // se captura y se une en un solo string.
            .toList(); // se captura y se devuelve como una lista de string.
        
        
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body( new ApiErrorResponse<List<String>>(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST,
                message,
                request.getRequestURI()));
    }


    //creamos funciones para manejar exceptions generics.
    // @ExceptionHandler(Exception.class)
    // public ResponseEntity<String> handleException( Exception exception) {
    //     return  ResponseEntity.internalServerError()
    //         .body(exception.getMessage());
    // }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse<String>> handleException( Exception exception, HttpServletRequest request) {
        return  ResponseEntity.internalServerError()
            .body(new ApiErrorResponse<String>(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST,
                exception.getMessage(),
                request.getRequestURI()));
    }


}
