package com.gcu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gcu.business.VehiclesBusinessServiceInterface;
import com.gcu.model.VehicleModel;

import jakarta.validation.Valid;

/**
 * VehicleController handles HTTP requests related to vehicle registration, display, edit, and delete.
 */
@Controller
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private VehiclesBusinessServiceInterface vehiclesService;

    /**
     * Display all registered vehicles.
     */
    @GetMapping("/all")
    public String displayVehicles(Model model) {
        List<VehicleModel> vehicles = vehiclesService.getVehicles();
        model.addAttribute("title", "Registered Vehicles");
        model.addAttribute("registeredVehicles", vehicles);
        return "vehicles"; // Thymeleaf view name
    }

    /**
     * Show vehicle registration form.
     */
    @GetMapping("/new")
    public String displayVehicleRegistration(Model model) {
        model.addAttribute("title", "New Vehicle Registration");
        model.addAttribute("vehicleModel", new VehicleModel());
        return "vehicleRegistration";
    }

    /**
     * Handle new vehicle form submission.
     */
    @PostMapping("/doVehicleRegistration")
    public String doVehicleRegistration(
            @Valid @ModelAttribute("vehicleModel") VehicleModel vehicleModel,
            BindingResult bindingResult,
            Model model,
            RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() || !vehicleModel.isValid()) {
            model.addAttribute("title", "New Vehicle Registration");
            return "vehicleRegistration";
        }

        boolean added = vehiclesService.addVehicle(vehicleModel);
        if (added) {
            redirectAttributes.addFlashAttribute("message", "Vehicle registered successfully!");
            return "redirect:/vehicles/all";
        } else {
            model.addAttribute("error", "Error: Could not register vehicle.");
            return "vehicleRegistration";
        }
    }

    /**
     * Show vehicle edit form.
     */
    @GetMapping("/edit/{id}")
    public String displayEditVehicle(@PathVariable("id") int id, Model model, RedirectAttributes redirectAttributes) {
        VehicleModel vehicle = vehiclesService.getVehicleById(id);
        if (vehicle == null) {
            redirectAttributes.addFlashAttribute("error", "Vehicle not found.");
            return "redirect:/vehicles/all";
        }

        model.addAttribute("title", "Edit Vehicle");
        model.addAttribute("vehicleModel", vehicle);
        return "vehicleEdit";
    }

    /**
     * Handle update submission for a vehicle.
     */
    @PostMapping("/update")
    public String updateVehicle(
            @Valid @ModelAttribute("vehicleModel") VehicleModel vehicleModel,
            BindingResult bindingResult,
            Model model,
            RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() || !vehicleModel.isValid()) {
            model.addAttribute("title", "Edit Vehicle");
            return "vehicleEdit";
        }

        boolean updated = vehiclesService.updateVehicle(vehicleModel);
        if (updated) {
            redirectAttributes.addFlashAttribute("message", "Vehicle updated successfully!");
        } else {
            redirectAttributes.addFlashAttribute("error", "Error: Could not update vehicle.");
        }
        return "redirect:/vehicles/all";
    }

    /**
     * Handle vehicle deletion by ID.
     */
    @GetMapping("/delete/{id}")
    public String deleteVehicle(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        boolean success = vehiclesService.deleteVehicleById(id);

        if (success) {
            redirectAttributes.addFlashAttribute("message", "Vehicle deleted successfully!");
        } else {
            redirectAttributes.addFlashAttribute("error", "Vehicle not found or could not be deleted.");
        }

        return "redirect:/vehicles/all";
    }
}

