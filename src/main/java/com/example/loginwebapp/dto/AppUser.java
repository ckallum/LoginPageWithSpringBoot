package com.example.loginwebapp.dto;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
public class AppUser{

    private int id;
    private int user_id;
    private int role_id;

}
