/**
 * 
 */
package com.hmhco.sgminterest.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hmhco.sgminterest.domain.Profile;
import com.hmhco.sgminterest.domain.User;
import com.hmhco.sgminterest.persistence.UserDAO;
import com.hmhco.sgminterest.persistence.UserRepository;
import com.hmhco.sgminterest.service.ProfileService;

/**
 * @author damodaranv
 *
 */
@RestController
@RequestMapping(value = "/")
public class UserController {

	private final Logger LOG = LoggerFactory.getLogger(getClass());

	private final UserRepository userRepository;

	private final UserDAO userDAO;
	
	@Autowired
	private ProfileService profileService;

	public UserController(UserRepository userRepository, UserDAO userDAO) {
		this.userRepository = userRepository;
		this.userDAO = userDAO;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public List<Profile> addNewUsers(@RequestBody User user) {
		LOG.info("Saving user.");
		return profileService.getProfiles(user);
		
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		LOG.info("Getting all users.");
		return userRepository.findAll();
	}

	
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public Optional<User> getUser(@PathVariable String userId) {
		LOG.info("Getting user with ID: {}.", userId);
//		return userRepository.findOne(new Query(Criteria.where("userId").is(userId)), User.class);
		return userRepository.findById(userId);
	}


	@RequestMapping(value = "/responses/{userId}", method = RequestMethod.GET)
	public Object getAllUserResponses(@PathVariable String userId) {
//		User user = userRepository.findOne(new Query(Criteria.where("userId").is(userId)), User.class);
		Optional<User> user = userRepository.findById(userId);
		if (user != null) {
			return userDAO.getAllUserResponses(userId);
		} else {
			return "User not found.";
		}
	}

}