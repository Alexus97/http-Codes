package com.dev.jt.httpcodes.exception;

public class UserNotFoundException extends RuntimeException {

    // mensaje por defecto es usuario no encontrado, pero lo podemos personaliar.

    public UserNotFoundException() {
        super( "El usuario no ha sido encontrado en el sistema.");
    }

    public UserNotFoundException(String message) {
        super( message );
    }
}



