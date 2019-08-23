package com.example.loginwebapp.controller;

import com.example.loginwebapp.config.WebConfig;
import com.example.loginwebapp.domain.UserPrincipal;
import com.example.loginwebapp.service.impl.UserService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@EnableAutoConfiguration
public class MappingController {

    @Autowired
    private UserService userService;

    @GetMapping(value = {"/", "/home"})
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/views/home");
        return mv;
    }

    @GetMapping("/admin")
    public ModelAndView admin() {
        ModelAndView mv = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal principal = (UserPrincipal) auth.getPrincipal();
        mv.addObject("userName", "Welcome " + principal.getUsername() + " (" + principal.getId() + ")");
        mv.addObject("adminMessage", "Content Available Only for Users with Admin Role");
        mv.setViewName("/views/admin");
        return mv;
    }

    @GetMapping("/login")
    public String login() {
        return "views/login";
    }

    @GetMapping("logoutsuccess")
    public String logoutSuccess(Model model) {
        model.addAttribute("title", "Logout");
        return "/views/logoutsuccess";
    }

    @GetMapping("/403")
    public ModelAndView error(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/error/403");

        return mv;
    }
}
