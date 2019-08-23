package com.example.loginwebapp.controller;

import com.example.loginwebapp.dto.AppUser;
import com.example.loginwebapp.service.impl.AppUserService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@EnableAutoConfiguration
@RequestMapping("/test")
public class TestController {
    @Resource
    private AppUserService service;

    @RequestMapping(value = "/{id}", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public AppUser getAppUser(@PathVariable("id") final int id) {
        return service.getAppUser(id);
    }

}
