package com.example.adminuserregistrationlogin.controller;

import com.example.adminuserregistrationlogin.dto.request.SaveUserRequest;
import com.example.adminuserregistrationlogin.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class UserController {

    private final UserDetailsService userDetailsService;
    private final UserService userService;

    public UserController(UserDetailsService userDetailsService, UserService userService) {
        this.userDetailsService = userDetailsService;
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String getRegistrationPage(@ModelAttribute("user") SaveUserRequest request) {
        return "register";
    }

    @PostMapping("/registration")
    public String saveUser(@ModelAttribute("user") SaveUserRequest request, Model model) {
        userService.save(request);
        model.addAttribute("message", "Registered Successfully");
        return "register";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("user-page")
    public String userPage(Model model, Principal principal) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);
        return "user";
    }

    @GetMapping("admin-page")
    public String adminPage(Model model, Principal principal) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);
        return "admin";
    }
}