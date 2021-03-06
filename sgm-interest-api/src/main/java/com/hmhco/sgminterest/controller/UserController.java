/**
 * 
 */
package com.hmhco.sgminterest.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hmhco.sgminterest.domain.Question;
import com.hmhco.sgminterest.domain.Recommendation;
import com.hmhco.sgminterest.domain.User;
import com.hmhco.sgminterest.service.RecommendationService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
/**
 * @author damodaranv
 *
 */
@RestController
@RequestMapping("/api")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private RecommendationService service;
	
	@ApiOperation(value = "Retrieves the student recommendations")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Student recommendations retrieved successfully") })
	@PostMapping("/userRecommendations")
    ResponseEntity<?> getRecommendations(@Valid @RequestBody User user) {
		
		logger.info("User Object is receiveed " + user.toString());
		
		List<Recommendation> recommendationList = service.getRecommendations(user);
		if(recommendationList != null && !recommendationList.isEmpty()) {
			logger.info("recommendationList size " + recommendationList.size());
			return (new ResponseEntity<List<Recommendation>>(recommendationList, HttpStatus.OK));
		} else {
			return (new ResponseEntity<>(HttpStatus.NOT_FOUND));
		}
			
    }
	
	@GetMapping("/user/{id}")
    ResponseEntity<?> getGroup(@PathVariable Long id) {
		Question q = new Question();
		q.setId(1);
		q.setLabel("dummyQ");
		q.setAnswer("dummyAns");
		List<Question> qList = new ArrayList<>();
		
		User user = new User();
		user.setFirstName("Vibin");
		user.setLastName("D");
		user.setUserId("1");
		user.setGrade("8");
		user.setQuestions(qList);
		
        return (new ResponseEntity<User>(user, HttpStatus.OK));
    }
	
	@GetMapping("/users")
    ResponseEntity<?> getGreeting() {
		
		User user1 = new User();
		user1.setFirstName("Vibin1");
		
		User user2 = new User();
		user2.setFirstName("Vibin2");
		
		List<User> userList = new ArrayList<User>();
		userList.add(user1);
		userList.add(user2);
		
        return (new ResponseEntity<List<User>>(userList, HttpStatus.OK));
    }

}
