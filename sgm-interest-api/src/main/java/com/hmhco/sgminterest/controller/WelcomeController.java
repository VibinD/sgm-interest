/**
 * 
 */
package com.hmhco.sgminterest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author damodaranv
 *
 */
@RestController
@RequestMapping("/api")
public class WelcomeController {
	
	@GetMapping("/")
    public String getGreeting() {
		
        return "Welcome to Spring Boot API";
    }

}
