package com.example.loginwebapp.service;

import com.example.loginwebapp.entity.AppUser;

import java.util.List;

public interface IAppUser {
    public AppUser getAppUser(int id);
    public List<AppUser> findAll();
    public int getUserID(int id);
    public int getRoleID(int id);

}
