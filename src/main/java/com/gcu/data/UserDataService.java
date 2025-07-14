package com.gcu.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.UserEntity;
import com.gcu.data.repository.UsersRepository;

@Service
public class UserDataService implements DataAccessInterface<UserEntity>, UsersDataAccessInterface<UserEntity> {

	@Autowired
	UsersRepository usersRepository;
	
	/**
	 * CRUD locate a User by username
	 */
	@Override
	public UserEntity findByUsername(String username) {
		 return usersRepository.findByUsername(username);
	}

	/**
	 * Not necessary for USERSERVICE
	 */
	@Override
	public List<UserEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not necessary for USERSERVICE
	 */
	@Override
	public UserEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not necessary for USERSERVICE
	 */
	@Override
	public boolean create(UserEntity t) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not necessary for USERSERVICE
	 */
	@Override
	public boolean update(UserEntity t) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not necessary for USERSERVICE
	 */
	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not necessary for USERSERVICE
	 */
	@Override
	public boolean delete(UserEntity t) {
		// TODO Auto-generated method stub
		return false;
	}

}
