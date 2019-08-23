package com.example.loginwebapp.service.impl;

import com.example.loginwebapp.dao.AppUserMapper;
import com.example.loginwebapp.dao.RoleMapper;
import com.example.loginwebapp.dao.UserMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService implements UserDetailsService {

    @Resource
    AppUserMapper apmapper;

    @Resource
    RoleMapper roleMapper;

    @Resource
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
