package com.dev.jt.httpcodes.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


// @JsonInclude(JsonInclude.Include.NON_NULL) // Para no mostrar los campos que son nulos en el JSON.
// @JsonIgnoreProperties({"password" }) // Para ignorar un campo en especifico, no se mostrara en el JSON.

public class UserDto {

    //@JsonAlias({"userName, username"}) // Para llamar a un campo por multiples valores o nombres.
    @JsonProperty(value = "user_name", index = 0) // renombrar o realizar la asignacion para visualizar como queremos presentar el JSON.
    private String userName;

    private String email;
    
    @JsonIgnore // para ignorar uno por uno.
    private String password;

    @JsonAlias({"nombre", "fullname"})
    private String name;

     //@JsonIgnore
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy") // Para formatear la fecha en el JSON.
    @JsonProperty("hire_date")
    private LocalDate hireDate;

    //@JsonIgnore
    private Boolean active;

    
   

    
    public UserDto() {
    }
    
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
    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }


    @Override
    public String toString() {
        return "UserDto [userName=" + userName + ", email="
        + email + ", password=" + password + ", name="
        + name + ", hireDate=" + hireDate + ", active = " + active + "]";
    }

}
