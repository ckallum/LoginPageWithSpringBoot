package com.example.loginwebapp.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class User {
    private int user_id;
    private String user_name;
    private String encrypted_password;
    private boolean enabled;
}
