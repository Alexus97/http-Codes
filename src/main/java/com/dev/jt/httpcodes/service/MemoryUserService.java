package com.dev.jt.httpcodes.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dev.jt.httpcodes.dto.UserDto;
import com.dev.jt.httpcodes.dto.UserRequest;
import com.dev.jt.httpcodes.exception.AlreadyExistException;
import com.dev.jt.httpcodes.exception.MissingValuesException;
import com.dev.jt.httpcodes.exception.UserNotFoundException;

@Service
public class MemoryUserService implements UserService{

    //private final GlobalController globalController;

    // Utiliar memoria.
    private List<UserDto> list = new ArrayList<>();

    /*MemoryUserService(GlobalController globalController) {
        this.globalController = globalController;
    }*/

    @Override
    public List<UserDto> getAll() {
        return list;
    }

    @Override
    public UserDto getByUserName(String username) {
        return list.stream()
            .filter(u -> u.getUserName().equals(username))
            .findFirst()
            .orElseThrow( () -> new UserNotFoundException());
    }


    @Override
    public UserDto getByEmail(String email) {
        return list.stream()
            .filter(u -> u.getEmail().equals(email))
            .findFirst()
            .orElseThrow( () -> new UserNotFoundException( "No fue encontrado ningun usuario con el email dado."));
    }


    @Override
    public UserDto create( UserRequest user) {
        //var exist = false;

        // Validar el username.

        // if(user.getUsername() == null || getByUserName(user.getUserName()) != null) {
        //     throw new Exception();
        // }


        // Validar el username si no existe(modo estricto , campos obligatorios).
        if(user.getUserName() == null || user.getUserName().isBlank()) {
            throw new MissingValuesException("El nombre del usuario no fue dado.");
        } try {
            getByUserName(user.getUserName());
            throw new AlreadyExistException("Ya existe un usuario con el username dado.");
            
        } catch ( UserNotFoundException e) {
            // esta bien.

        }

        // Validar el username.
        /*if(getByUserName(user.getUsername()) != null) {
            throw new AlreadyExistException("Ya existe el usuario con el username dado.");

        }*/

        // Validar si el email no existe(modo estricto).
        if(user.getEmail() == null || user.getEmail().isBlank()) {
            throw new MissingValuesException("El correo electronico no fue dado.");
        } try {
            getByEmail(user.getEmail());
            throw new AlreadyExistException("Ya existe un usuario con el email dado.");
            
        } catch ( UserNotFoundException e) {
            // esta bien.
            
        }


        // Validar que exista el email.
        /*if(getByEmail(user.getEmail()) != null) {
            throw new AlreadyExistException("Ya existe un usuario con el email dado.");
        }*/

        var newUser = new UserDto();
        newUser.setName(user.getName());
        newUser.setUserName(user.getUserName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setHireDate(LocalDate.now()); // si creo un usuario que viene en blanco o por defecto, siempre le asigna la fecha actual.
        newUser.setActive(true); // si creo un usuario que viene en blanco o por defecto, siempre lo activa.
        
        System.out.println(newUser);
        list.add(newUser);

        
        return newUser;
    }


    @Override
    public void delete(String username) {
        /*list = list.stream()
            .filter(u -> !u.getUsername().equals(username))
            .toList();*/

        var existing  = getByUserName(username);

        list.remove(existing);


    }


}

