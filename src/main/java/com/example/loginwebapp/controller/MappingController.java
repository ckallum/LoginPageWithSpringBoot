package com.example.loginwebapp.controller;

import com.example.loginwebapp.domain.UserPrincipal;
import com.example.loginwebapp.entity.User;
import com.example.loginwebapp.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class MappingController {

    @Autowired
    private UserService userService;

    @GetMapping(value = {"/", "/home"})
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/home");
        return mv;
    }

    @GetMapping("/register")
    public ModelAndView registration(){
        ModelAndView mv = new ModelAndView();
        User user = new User();
        mv.addObject("user", user);
        mv.setViewName("/register");
        return mv;
    }

    @PostMapping("/register")
    public ModelAndView registerUser(@Valid User user, BindingResult bindingResult){
        ModelAndView model = new ModelAndView();
        User userExist = userService.getUserByName(user.getUser_name());
        if (userExist != null){
            bindingResult.rejectValue("loginId", "loginId", "User already exists");
        }
        if (bindingResult.hasErrors()){
            model.setViewName("/register");
        }
        else{
            userService.createUser(user);
            model.addObject("successMessage", "User has been registered");
            model.addObject("user", new User());
            model.setViewName("/home");
        }
        return model;
    }

    @GetMapping("/admin")
    public ModelAndView admin() {
        ModelAndView mv = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal principal = (UserPrincipal) auth.getPrincipal();
        mv.addObject("userName", "Welcome " + principal.getUsername() + " (" + principal.getId() + ")");
        mv.addObject("adminMessage", "Content Available Only for Users with Admin Role");
        mv.setViewName("/admin");
        return mv;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/logoutsuccess")
    public ModelAndView logoutsuccess() {
        ModelAndView model = new ModelAndView();
        model.addObject("title", "Logout");
        model.setViewName("/logoutsuccess");
        return model;
    }

    @GetMapping("/403")
    public ModelAndView error(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/403");

        return mv;
    }
}
