package com.example.loginwebapp.service.impl;

import com.example.loginwebapp.dao.AppUserMapper;
import com.example.loginwebapp.dao.RoleMapper;
import com.example.loginwebapp.dao.UserMapper;
import com.example.loginwebapp.domain.UserPrincipal;
import com.example.loginwebapp.entity.AppUser;
import com.example.loginwebapp.entity.Role;
import com.example.loginwebapp.service.IUser;
import com.example.loginwebapp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    AppUserMapper apmapper;

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    BCryptPasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userMapper.selectByName(s);
        return new UserPrincipal(user);
    }

    public User loadUserByID(int id){
        return userMapper.select(id);
    }

    public User getUserByName(String name){
        return userMapper.selectByName(name);
    }


    public void createUser(User user) {
        user.setEnabled(true);
        user.setEncrypted_password(encoder.encode(user.getEncrypted_password()));
        userMapper.insertUser(user);
        Role role = roleMapper.selectByName("ADMIN");
        AppUser au = new AppUser();
        au.setRole_id(role.getRole_id());
        au.setUser_id(user.getUser_id());
        apmapper.insertUser(au);

    }




}
