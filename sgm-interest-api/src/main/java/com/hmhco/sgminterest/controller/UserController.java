/**
 * 
 */
package com.hmhco.sgminterest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	@Autowired
	private RecommendationService service;
	
	@ApiOperation(value = "Retrieves the student recommendations")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Student recommendations retrieved successfully") })
	@PostMapping("/userRecommendations")
    ResponseEntity<?> getRecommendations(@Valid @RequestBody User user) {
		List<Recommendation> recommendationList = service.getRecommendations(user);
		if(recommendationList != null && !recommendationList.isEmpty())
			return (new ResponseEntity<List<Recommendation>>(recommendationList, HttpStatus.OK));
		else
			return (new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
