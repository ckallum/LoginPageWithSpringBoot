package com.example.loginwebapp.service;

import com.example.loginwebapp.entity.Role;

import java.util.List;

public interface IRole {
    public int getRoleName(int id);
    public List<Role> findRoles();
}
