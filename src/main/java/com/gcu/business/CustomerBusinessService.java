package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public void init() {
        System.out.println("Customer Business Service initialized.");
    }

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

    @Override
    public boolean addCustomer(CustomerModel customer) {
        return service.create(new CustomerEntity(
            customer.getCustomerId(), customer.getFirstName(), customer.getLastName(),
            customer.getEmail(), customer.getPhoneNumber(),
            customer.getUsername(), customer.getPassword()
        ));
    }

    @Override
    public boolean updateCustomer(CustomerModel customer) {
        return service.update(new CustomerEntity(
            customer.getCustomerId(), customer.getFirstName(), customer.getLastName(),
            customer.getEmail(), customer.getPhoneNumber(),
            customer.getUsername(), customer.getPassword()
        ));
    }

    @Override
    public boolean deleteCustomer(int id) {
        CustomerEntity entity = service.findById(id);
        if (entity != null) {
            return service.delete(entity);
        }
        return false;
    }

    @Override
    public void deleteCustomerById(int id) {
        CustomerEntity entity = service.findById(id);
        System.out.println("Found customer for deletion: " + entity); // Log
        if (entity != null) {
            service.delete(entity);
        } else {
            System.out.println("Customer not found for ID: " + id);
        }
    }


    @Override
    public void destroy() {
        System.out.println("Customer Business Service terminated.");
    }
}
