package com.at.library.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.at.library.model.User;

@Repository
public interface UserDao extends CrudRepository<User, Integer> {

	List<User> findByDniOrNameOrSurname1OrSurname2OrAddress(String dni, String name, 
			String surname1, String surname2, String address);
}
