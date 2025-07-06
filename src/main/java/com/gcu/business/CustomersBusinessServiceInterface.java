package com.gcu.business;

import java.util.List;
import com.gcu.model.CustomerModel;

/**
 * Interface defines the contract for CustomerBusinessService
 */
public interface CustomersBusinessServiceInterface {
    
    void init();
    List<CustomerModel> getCustomers();
    CustomerModel getCustomerById(String customerId);
    boolean addCustomer(CustomerModel customer);
    boolean updateCustomer(CustomerModel customer);  //  Added
    boolean deleteCustomer(int id); 
    public void deleteCustomerById(int id);
                                                     
    void destroy();
}
