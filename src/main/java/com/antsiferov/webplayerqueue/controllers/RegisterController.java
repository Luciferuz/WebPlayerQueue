package com.antsiferov.webplayerqueue.controllers;

import com.antsiferov.webplayerqueue.entity.User;
import com.antsiferov.webplayerqueue.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class RegisterController {

    private UserService userService;

    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    public String addUser(@RequestParam String name, @RequestParam String password) {
        String encryptedPwd = passwordEncoder.encode(password);
        User user = new User(name, encryptedPwd);
        userService.save(user);
        return "redirect:/login";
    }

}