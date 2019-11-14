/**
 * 
 */
package com.hmhco.sgminterest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hmhco.sgminterest.domain.User;

/**
 * @author damodaranv
 *
 */
@RestController
@RequestMapping("/api")
public class UserController {
	
	//@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/users")
    ResponseEntity<?> getGreeting() {
		
		User user1 = new User("1", "Vibin1", "vibin1@hmhco.com");
		User user2 = new User("2", "Vibin 2 ", "vibin2@hmhco.com");
		User user3 = new User("3", "Vibin 3 ", "vibin3@hmhco.com");
		
		List<User> userList = new ArrayList<User>();
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		
        return (new ResponseEntity<List<User>>(userList, HttpStatus.OK));
    }
	
	
	@GetMapping("/user/{id}")
    ResponseEntity<?> getGroup(@PathVariable Long id) {
		User user = new User("1", "Vibin1", "vibin1@hmhco.com");
        return (new ResponseEntity<User>(user, HttpStatus.OK));
    }

}
