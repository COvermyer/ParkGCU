package com.gcu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.gcu.business.CustomersBusinessServiceInterface;
import com.gcu.business.VehiclesBusinessServiceInterface;
import com.gcu.model.CustomerModel;
import com.gcu.model.VehicleModel;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import jakarta.validation.Valid;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomersBusinessServiceInterface customersService;

    @Autowired
    VehiclesBusinessServiceInterface vehiclesService;

    @GetMapping("/")
    public String display(Model model) {
        model.addAttribute("title", "Customer Info");
        model.addAttribute("customerModel", new CustomerModel());
        model.addAttribute("registeredVehicles", new ArrayList<VehicleModel>());
        return "customerInfo";
    }

    @GetMapping("/all")
    public String displayAll(Model model) {
        List<CustomerModel> registeredCustomers = customersService.getCustomers();
        model.addAttribute("title", "Customers");
        model.addAttribute("registeredCustomers", registeredCustomers);
        return "customers";
    }

    @GetMapping("/new")
    public String displayNewCustomerPage(Model model) {
        model.addAttribute("title", "New Customer Registration");
        model.addAttribute("customerModel", new CustomerModel());
        return "customerRegistration";
    }

    @PostMapping("/doCustomerRegistration")
    public String doCustomerRegistration(@Valid @ModelAttribute CustomerModel customerModel, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors() || !customersService.addCustomer(customerModel)) {
            model.addAttribute("title", "New Customer Registration");
            model.addAttribute("customerModel", customerModel);
            System.out.println("Failed Registration detected");
            return "customerRegistration";
        }

        model.addAttribute("message", "Registration successful! Please log in.");
        return "redirect:/login";
    }

    @GetMapping("/info/{customerId}")
    public String displayCustomerInfo(@PathVariable String customerId, Model model) {
        model.addAttribute("title", "Customer Info");
        model.addAttribute("customerModel", customersService.getCustomerById(customerId));
        model.addAttribute("registeredVehicles", vehiclesService.getVehiclesByCustomerId(customerId));
        return "customerInfo";
    }

    // ---------------- Edit / Update / Delete ----------------

    @GetMapping("/edit/{id}")
    public String editCustomer(@PathVariable int id, Model model) {
        CustomerModel customer = customersService.getCustomerById(String.valueOf(id));
        if (customer != null) {
        	model.addAttribute("title", "Edit Customer");
            model.addAttribute("customerModel", customer);
            return "customerEdit";
        }
        return "redirect:/customers/all";
    }

    @PostMapping("/update")
    public String updateCustomer(@ModelAttribute CustomerModel customer) {
        customersService.updateCustomer(customer);
        return "redirect:/customers/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        try {
            customersService.deleteCustomerById(id);
            redirectAttributes.addFlashAttribute("message", "Customer deleted successfully!");
        } catch (RuntimeException ex) {
            redirectAttributes.addFlashAttribute("error", ex.getMessage());
        }
        return "redirect:/customers/all";
    }

    
    @GetMapping("/test-delete/{id}")
    @ResponseBody
    public String testDelete(@PathVariable("id") int id) {
        CustomerModel customer = customersService.getCustomerById(String.valueOf(id));
        if (customer != null) {
            customersService.deleteCustomerById(id);
            return "Deleted customer with ID: " + id;
        } else {
            return "Customer with ID " + id + " not found.";
        }
    }

}
