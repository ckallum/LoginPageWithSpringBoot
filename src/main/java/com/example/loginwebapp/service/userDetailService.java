package com.example.loginwebapp.service;

import com.example.loginwebapp.dao.roleDao;
import com.example.loginwebapp.dao.userDao;
import com.example.loginwebapp.model.appUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class userDetailService implements UserDetailsService {
    @Autowired
    private com.example.loginwebapp.dao.userDao userDao;

    @Autowired
    com.example.loginwebapp.dao.roleDao roleDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        appUser user = this.userDao.findUserAccount(s);
        if (user == null){
            System.out.println("User not found "+ s);
            throw new UsernameNotFoundException("User" + s + "was not found in database");
        }
        System.out.println("Found User" + s);
        List<String> roles = this.roleDao.getRoles(user.getUserID());
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        if (roles != null){
            for (String role:roles){
                GrantedAuthority authority = new SimpleGrantedAuthority(role);
                authorities.add(authority);
            }
        }
        UserDetails details = (UserDetails) new User(user.getUserName(),user.getPassword(),authorities);
        return details;
    }
}
