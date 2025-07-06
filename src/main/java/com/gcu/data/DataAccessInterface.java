package com.gcu.data;

import java.util.List;

public interface DataAccessInterface<T> {
    List<T> findAll();
    T findById(int id);
    boolean create(T t);
    boolean update(T t);
    boolean deleteById(int id);            // ✅ for VehiclesDataService
    boolean delete(T t);                   // ✅ for CustomersDataService
}
