package com.dev.jt.httpcodes.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dev.jt.httpcodes.dto.UserDto;
import com.dev.jt.httpcodes.dto.UserRequest;
import com.dev.jt.httpcodes.service.UserService;

import jakarta.validation.Valid;



// No se trabaja con lombok.
@RestController
@RequestMapping("api/users")
public class UserController {

    // Injections dependencis for constructor.
    private final UserService userService;
    
    public UserController(UserService userService) {
        this.userService = userService;
    }


    // Para evitar redundancia y como se que springboot me devulve ok no es necesario colocarlo.@ResponseStatus("HttpStatus.OK")
    // @ResponseStatus(HttpStatus.OK)
    /*//public String getMethodName(@RequestParam String param) {
        return new String();
    }*/
    
    @GetMapping
    public List<UserDto> getAll() {
        
        return userService.getAll();
    }

    
    @GetMapping("/{username}")
    public UserDto getByUserName(@PathVariable String username) {
        
        return userService.getByUserName(username);
    }

    @GetMapping("/email")
    public UserDto getByEmail(@RequestParam String email) {
        return userService.getByEmail(email);
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserDto register(@Valid @RequestBody UserRequest user) {
        return userService.create(user);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{username}")
    public void delete(@PathVariable String username) {
        userService.delete(username);
    }


}
