package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gcu.data.CustomersDataService;
import com.gcu.data.entity.CustomerEntity;
import com.gcu.model.CustomerModel;

/**
 * Service to manage Customer DB
 */
@Service
public class CustomerBusinessService implements CustomersBusinessServiceInterface {

    @Autowired
    CustomersDataService service;

    /**
     * Service Init method
     */
    @Override
    public void init() {
        System.out.println("Customer Business Service initialized.");
    }

    /**
     * CRUD method to get a specific customer ID
     */
    @Override
    public CustomerModel getCustomerById(String customerId) {
        CustomerEntity e = service.findById(Integer.parseInt(customerId));
        if (e == null) {
            return null;
        }
        return new CustomerModel(
            e.getCustomerId(), e.getFirstName(), e.getLastName(),
            e.getEmail(), e.getPhoneNumber(), e.getUsername(), e.getPassword()
        );
    }

    /**
     * CRUD method to get all customers
     */
    @Override
    public List<CustomerModel> getCustomers() {
        List<CustomerEntity> customersEntity = service.findAll();
        List<CustomerModel> customersDomain = new ArrayList<>();
        for (CustomerEntity e : customersEntity) {
            customersDomain.add(new CustomerModel(
                e.getCustomerId(), e.getFirstName(), e.getLastName(),
                e.getEmail(), e.getPhoneNumber(), e.getUsername(), e.getPassword()
            ));
        }
        return customersDomain;
    }

    /**
     * CRUD method to add a customer
     */
    @Override
    public boolean addCustomer(CustomerModel customer) {
        return service.create(new CustomerEntity(
            customer.getCustomerId(), customer.getFirstName(), customer.getLastName(),
            customer.getEmail(), customer.getPhoneNumber(),
            customer.getUsername(), new BCryptPasswordEncoder().encode(customer.getPassword())
        ));
    }

    /**
     * CRUD method to update a customer
     */
    @Override
    public boolean updateCustomer(CustomerModel customer) {
        return service.update(new CustomerEntity(
            customer.getCustomerId(), customer.getFirstName(), customer.getLastName(),
            customer.getEmail(), customer.getPhoneNumber(),
            customer.getUsername(), new BCryptPasswordEncoder().encode(customer.getPassword())
        ));
    }

    /**
     * CRUD method to delete a customer
     */
    @Override
    public boolean deleteCustomer(int id) {
        CustomerEntity entity = service.findById(id);
        if (entity != null) {
            return service.delete(entity);
        }
        return false;
    }

    /**
     * Service destruction method
     */
    @Override
    public void destroy() {
        System.out.println("Customer Business Service terminated.");
    }
}
