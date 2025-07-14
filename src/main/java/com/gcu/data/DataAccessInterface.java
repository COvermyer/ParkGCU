package com.gcu.data;

import java.util.List;

/**
 * Defines the Contract for any DAO service
 * @param <T> object type
 */
public interface DataAccessInterface<T> {
    List<T> findAll();
    T findById(int id);
    boolean create(T t);
    boolean update(T t);
    boolean deleteById(int id);
    boolean delete(T t);
}
