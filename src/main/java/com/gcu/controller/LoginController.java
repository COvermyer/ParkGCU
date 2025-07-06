package com.gcu.controller;

import com.gcu.business.SecurityBusinessServiceInterface;
import com.gcu.business.VehiclesBusinessServiceInterface;
import com.gcu.model.LoginModel;
import com.gcu.model.VehicleModel;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private SecurityBusinessServiceInterface security;

    @Autowired
    private VehiclesBusinessServiceInterface vehicleService;

    /**
     * Display login form at /login or /login/
     */
    @GetMapping({"", "/"})
    public String displayLoginForm(Model model) {
        model.addAttribute("title", "Login Form");
        model.addAttribute("loginModel", new LoginModel());
        return "login";  // login.html view
    }

    /**
     * Process login form submission at /login/doLogin
     */
    @PostMapping("/doLogin")
    public String processLogin(@Valid @ModelAttribute("loginModel") LoginModel loginModel,
                               BindingResult bindingResult,
                               Model model) {

        model.addAttribute("title", "Login Form");

        // Check form validation
        if (bindingResult.hasErrors()) {
            model.addAttribute("error", "Form validation failed.");
            return "login";
        }

        // Authenticate user
        if (!security.authenticate(loginModel.getUsername(), loginModel.getPassword())) {
            model.addAttribute("error", "Invalid username or password.");
            return "login";
        }

        // On success - show vehicles
        List<VehicleModel> vehicles = vehicleService.getVehicles();
        model.addAttribute("title", "Registered Vehicles");
        model.addAttribute("registeredVehicles", vehicles);

        return "vehicles";  // vehicles.html view
    }
}
