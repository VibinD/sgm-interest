package com.hmhco.sgminterest.persistence;

import java.util.List;

import com.hmhco.sgminterest.domain.User;


public interface UserDAO {

	List<User> getAllUsers();

	User getUserById(String userId);

	User addNewUser(User user);

	Object getAllUserResponses(String userId);
}
