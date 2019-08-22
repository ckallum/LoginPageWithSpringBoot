package com.example.loginwebapp.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@Getter
@Setter
public class appUser implements Serializable {
    private final long serialUUID = 1L;

    private Long id;
    private String username;
    private String password;

    @Override
    public String toString(){
        return this.username +"/" + this.password;
    }
}
