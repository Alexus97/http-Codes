package com.dev.jt.httpcodes.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserRequest {
    @NotBlank(message = "El nombre de usuario es obligatorio")
    @JsonAlias({"userName, username"}) // Para llamar a un campo por multiples valores o nombres.
    @JsonProperty(value = "user_name", index = 0)
    private String userName;

    
    @NotBlank(message = "El correo electronico es obligatorio")
    @Email(message = "El formato del correo electronico no es valido")
    private String email;

    
    //@JsonIgnore
    @NotBlank
    private String password;

    @JsonAlias({"nombre", "fullname"})
    private String name;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    
    
    


    
}
