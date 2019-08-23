package com.example.loginwebapp.service.impl;

import com.example.loginwebapp.dao.AppUserMapper;
import com.example.loginwebapp.dto.AppUser;
import com.example.loginwebapp.service.IAppUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AppUserService implements IAppUser{

    @Resource
    AppUserMapper mapper;

    @Override
    public AppUser getAppUser(int id) {
        return mapper.select(id);
    }
    @Override
    public List<AppUser> findAll() {
        return mapper.findAll();
    }
}
