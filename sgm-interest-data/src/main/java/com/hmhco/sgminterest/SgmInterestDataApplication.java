package com.hmhco.sgminterest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.hmhco")
public class SgmInterestDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(SgmInterestDataApplication.class, args);

	}
}
