package com.gcu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.gcu.business.CustomersBusinessServiceInterface;
import com.gcu.business.VehiclesBusinessServiceInterface;
import com.gcu.model.CustomerModel;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import jakarta.validation.Valid;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomersBusinessServiceInterface customersService;

    @Autowired
    VehiclesBusinessServiceInterface vehiclesService;

    /**
     * method to display customers list display
     * @param model
     * @return
     */
    @GetMapping("/all")
    public String displayAll(Model model) {
        List<CustomerModel> registeredCustomers = customersService.getCustomers();
        model.addAttribute("title", "Customers");
        model.addAttribute("registeredCustomers", registeredCustomers);
        return "customers";
    }

    /**
     * method to display "New Customer" page
     * @param model
     * @return
     */
    @GetMapping("/new")
    public String displayNewCustomerPage(Model model) {
        model.addAttribute("title", "New Customer Registration");
        model.addAttribute("customerModel", new CustomerModel());
        return "customerRegistration";
    }

    /**
     * Method for POST passing new customers from customer registration
     * @param customerModel
     * @param bindingResult
     * @param model
     * @return
     */
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

    /**
     * Method for displaying a customer's direct information in the Customer Info page
     * @param customerId
     * @param model
     * @return
     */
    @GetMapping("/info/{customerId}")
    public String displayCustomerInfo(@PathVariable String customerId, Model model) {
        model.addAttribute("title", "Customer Info");
        model.addAttribute("customerModel", customersService.getCustomerById(customerId));
        model.addAttribute("registeredVehicles", vehiclesService.getVehiclesByCustomerId(customerId));
        return "customerInfo";
    }

    // ---------------- Edit / Update / Delete ----------------

    /**
     * Method for displaying the Edit Customer page
     * @param id
     * @param model
     * @return
     */
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

    /**
     * POST processing method for the "Update Customer" page
     * @param customer
     * @return
     */
    @PostMapping("/update")
    public String updateCustomer(@ModelAttribute CustomerModel customer) {
        customersService.updateCustomer(customer);
        return "redirect:/customers/all";
    }

    /**
     * Method for deleting a customer from the customer List
     * @param id
     * @param redirectAttributes
     * @return
     */
    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        try {
            customersService.deleteCustomer(id);
            redirectAttributes.addFlashAttribute("message", "Customer deleted successfully!");
        } catch (RuntimeException ex) {
            redirectAttributes.addFlashAttribute("error", ex.getMessage());
        }
        return "redirect:/customers/all";
    }
}
