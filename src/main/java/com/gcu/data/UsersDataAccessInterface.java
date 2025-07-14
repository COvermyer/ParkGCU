package com.gcu.data;

/**
 * Defines additional contracts for a DAO object
 * @param <T> object type
 */
public interface UsersDataAccessInterface <T> {
	public T findByUsername(String username);
}
