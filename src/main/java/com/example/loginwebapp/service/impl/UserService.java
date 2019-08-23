package com.example.loginwebapp.service.impl;

import com.example.loginwebapp.dao.AppUserMapper;
import com.example.loginwebapp.dao.RoleMapper;
import com.example.loginwebapp.dao.UserMapper;
import com.example.loginwebapp.domain.UserPrincipal;
import com.example.loginwebapp.service.IUser;
import com.example.loginwebapp.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService implements UserDetailsService, IUser {

    @Resource
    AppUserMapper apmapper;

    @Resource
    RoleMapper roleMapper;

    @Resource
    UserMapper userMapper;

    @Resource
    BCryptPasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userMapper.selectByName(s);
        return new UserPrincipal(user);
    }

    @Override
    public String getUsername(int id) {
        return userMapper.getUsername(id);
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    public void createUser(User user) {
        user.setEnabled(true);
        user.setEncrypted_password(encoder.encode(user.getEncrypted_password()));
        userMapper.insertUser(user);

    }

    @Override
    public User getUser(int id) {
        return null;
    }
}
