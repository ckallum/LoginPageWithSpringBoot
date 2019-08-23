package com.example.loginwebapp.service;

import com.example.loginwebapp.entity.User;
import java.util.List;

public interface IUser {
    public String getUsername(int id);
    public List<User> findAll();
    public void createUser(User user);
    public User getUser(int id);

}
