package com.dev.jt.httpcodes.service;

import java.util.List;

import com.dev.jt.httpcodes.dto.UserDto;
import com.dev.jt.httpcodes.dto.UserRequest;

public interface UserService {

    // Trae todos los elementos
    List<UserDto> getAll();

    // Obtiene un usuario por nombre.
    UserDto getByUserName(String username);

    // Obtiene un email.
    UserDto getByEmail(String email);

    // Crea un usuario.
    UserDto create(UserRequest user);

    // Elimina un usuario por nombre.
    void delete(String username);

    
    

}
