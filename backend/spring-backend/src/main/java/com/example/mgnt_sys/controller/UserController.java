package com.example.mgnt_sys.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;


import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

import com.example.mgnt_sys.model.User;
import com.example.mgnt_sys.repository.UserRepository;

import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public String getForm() {
        return "redirect:/register.html";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "redirect:/login.html";
    }

    @GetMapping("/logout")
    public String getLogout(HttpServletResponse res) {
        Cookie cookie = new Cookie("userSession",null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        res.addCookie(cookie);
        return "redirect:/logout.html";
    }

    @PostMapping("/submita")
    @ResponseBody
    public String handleFormSubmission(
            @RequestParam String name,
            @RequestParam String username,
            @RequestParam String email,
            @RequestParam String password) {

        User data = new User();
        data.setName(name);
        data.setUsername(username);
        data.setEmail(email);
        data.setPassword(password);

        userRepository.save(data);

        return "Form Sumbitted!! --> \nFirst Name: " + name + ", Last Name: " + username + " email : " + email
                + " password : " + password;
    }

    @PostMapping("/login_check")
    @ResponseBody
    public String handleLogin(
        @RequestParam String username,
        @RequestParam String password,
        HttpServletResponse res
        ){

            User user = userRepository.findByUsername(username);
            if(user != null && user.getPassword().equals(password)){
                String sessionToken = UUID.randomUUID().toString();

                Cookie sessionCookie =  new Cookie("userSession", username + "-" + sessionToken);
                sessionCookie.setHttpOnly(true);
                sessionCookie.setMaxAge(3600);
                sessionCookie.setPath("/");

                res.addCookie(sessionCookie);

                return "Login successful!";

            }else{
                return "InValid Credentials!!";
            }
        }
}
