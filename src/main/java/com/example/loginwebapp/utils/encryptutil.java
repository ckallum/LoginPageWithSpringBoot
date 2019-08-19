package com.example.loginwebapp.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class encryptutil {
    public static String encrypt(String password){
        BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
}
