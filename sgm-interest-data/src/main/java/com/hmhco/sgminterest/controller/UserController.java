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

import com.hmhco.sgminterest.domain.Recommendation;
import com.hmhco.sgminterest.domain.UserSurvey;

/**
 * @author damodaranv
 *
 */
@RestController
@RequestMapping("/api")
public class UserController {
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/users")
    ResponseEntity<?> getGreeting() {
		
//		UserSurvey user1 = new UserSurvey("1", "Vibin1", "vibin1@hmhco.com");
//		UserSurvey user2 = new UserSurvey("2", "Vibin 2 ", "vibin2@hmhco.com");
//		UserSurvey user3 = new UserSurvey("3", "Vibin 3 ", "vibin3@hmhco.com");
//		
		List<Recommendation> recommendationList = new ArrayList<Recommendation>();
//		userList.add(user1);
//		userList.add(user2);
//		userList.add(user3);
		
        return (new ResponseEntity<List<Recommendation>>(recommendationList, HttpStatus.OK));
    }
	
	
//	@GetMapping("/user/{id}")
//    ResponseEntity<?> getGroup(@PathVariable Long id) {
//		UserSurvey user = new UserSurvey("1", "Vibin1", "vibin1@hmhco.com");
//        return (new ResponseEntity<UserSurvey>(user, HttpStatus.OK));
//    }

}
