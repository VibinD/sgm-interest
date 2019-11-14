package com.hmhco.sgminterest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.hmhco")
public class SgmInterestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SgmInterestApiApplication.class, args);
	}

}
