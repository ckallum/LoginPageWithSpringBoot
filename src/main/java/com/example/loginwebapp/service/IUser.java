package com.example.loginwebapp.service;

import org.springframework.security.core.userdetails.User;

import java.util.List;

public interface IUser {
    public String getUsername(int id);
    public List<User> findAll();
}
