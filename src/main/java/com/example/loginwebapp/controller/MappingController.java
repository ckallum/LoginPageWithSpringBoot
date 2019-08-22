package com.example.loginwebapp.controller;

import com.example.loginwebapp.utils.WebUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class MappingController {
    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String root(Model model){
        model.addAttribute("title", "Welcome");
        model.addAttribute("message", "Welcome Home!");
        return "home";
    }

    @GetMapping("/admin")
    public String admin(Model model, Principal principal) {
        User currentuser = (User)((Authentication) principal).getPrincipal();
        String userinfo = WebUtil.toString(currentuser);
        model.addAttribute("userinfo", userinfo);

        return "admin";
    }

    @GetMapping("/user")
    public String user(Model model, Principal principal){
        String username = principal.getName();
        System.out.println("Username = "+ username);
        User current = (User)((Authentication) principal).getPrincipal();
        String info = WebUtil.toString(current);
        model.addAttribute("userinfo", info);
        return "user";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("logoutsuccess")
    public String logoutSuccess(Model model){
        model.addAttribute("title", "Logout");
        return "logoutsuccess";
    }

    @GetMapping("/403")
    public String error(Model model, Principal principal) {
        if (principal != null){
            User current = (User)((Authentication)principal).getPrincipal();
            String info = WebUtil.toString(current);
            model.addAttribute("userinfo", info);
            String message = "Hi" + principal.getName() + "<br> You do not have permissions to access this page!";
            model.addAttribute("message", message);
        }
        return "/error/403";
    }
}
