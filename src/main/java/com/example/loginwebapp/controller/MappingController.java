package com.example.loginwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MappingController {
    @GetMapping("/")
    public String root(){
        return "home";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }

    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }

    @GetMapping("/user")
    public String user(){
        return "user";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/403")
    public String error() {
        return "/error/403";
    }
}
