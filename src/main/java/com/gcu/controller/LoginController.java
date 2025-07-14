package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
public class LoginController {

    /**
     * Display login form at /login or /login/
     */
    @GetMapping({"", "/"})
    public String displayLoginForm(Model model) {
        model.addAttribute("title", "Login Form");
        return "login";  // login.html view
    }
}
