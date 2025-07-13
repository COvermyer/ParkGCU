package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.CustomerEntity;
import com.gcu.data.mapper.CustomerRowMapper;
import com.gcu.data.repository.CustomersRepository;

@Service
public class CustomersDataService implements DataAccessInterface<CustomerEntity> {

    @Autowired
    private CustomersRepository customersRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<CustomerEntity> findAll() {
        List<CustomerEntity> customers = new ArrayList<>();
        try {
            Iterable<CustomerEntity> customersIterable = customersRepository.findAll();
            customersIterable.forEach(customers::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public CustomerEntity findById(int id) {
        String sql = "SELECT * FROM customers WHERE customerId = ?";
        try {
            List<CustomerEntity> results = jdbcTemplate.query(sql, new CustomerRowMapper(), id);
            if (!results.isEmpty()) {
                return results.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean create(CustomerEntity customer) {
        String sql = "INSERT INTO customers (customerId, firstName, lastName, email, phoneNumber, username, password) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            int num = jdbcTemplate.update(sql,
                    customer.getCustomerId(),
                    customer.getFirstName(),
                    customer.getLastName(),
                    customer.getEmail(),
                    customer.getPhoneNumber(),
                    customer.getUsername(),
                    customer.getPassword());
            System.out.println("Rows affected: " + num);
            return num == 1;
        } catch (DataAccessException d) {
            d.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(CustomerEntity customer) {
        String sql = "UPDATE customers SET firstName = ?, lastName = ?, email = ?, phoneNumber = ?, username = ?, password = ? WHERE customerId = ?";
        try {
            int num = jdbcTemplate.update(sql,
                    customer.getFirstName(),
                    customer.getLastName(),
                    customer.getEmail(),
                    customer.getPhoneNumber(),
                    customer.getUsername(),
                    customer.getPassword(),
                    customer.getCustomerId());
            System.out.println("Customer updated: " + num);
            return num == 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(CustomerEntity customer) {
        String sql1 = "DELETE FROM vehicles WHERE customerId = ?";
        String sql2 = "DELETE FROM customers WHERE customerId = ?";
        int rowsDeleted = 0;
        try {
            int vehiclesDeleted = jdbcTemplate.update(sql1, customer.getCustomerId());
            rowsDeleted = jdbcTemplate.update(sql2, customer.getCustomerId());
            System.out.println("Vehicles deleted: " + vehiclesDeleted);
            System.out.println("Customers deleted: " + rowsDeleted);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowsDeleted >= 1;
    }

    @Override
    public boolean deleteById(int id) {
        String sql1 = "DELETE FROM vehicles WHERE customerId = ?";
        String sql2 = "DELETE FROM customers WHERE customerId = ?";
        int rowsDeleted = 0;
        try {
            int vehiclesDeleted = jdbcTemplate.update(sql1, id);
            rowsDeleted = jdbcTemplate.update(sql2, id);
            System.out.println("Vehicles deleted: " + vehiclesDeleted);
            System.out.println("Customer deleted by ID: " + rowsDeleted);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowsDeleted >= 1;
    }

    public int validateUserLogin(String username, String password) {
        int customerId = -1;
        String sql = "SELECT * FROM customers WHERE UPPER(username) = ?";
        try {
            List<CustomerEntity> results = jdbcTemplate.query(sql, new CustomerRowMapper(), username.toUpperCase());
            if (results.isEmpty()) {
                System.out.println("Login failed: No user found with username " + username);
                return -1;
            }

            CustomerEntity customer = results.get(0);
            if (customer != null && customer.getPassword().equals(password)) {
                customerId = customer.getCustomerId();
                System.out.println("Login successful for user: " + username);
            } else {
                System.out.println("Login failed: Incorrect password for user " + username);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return customerId;
    }
}
