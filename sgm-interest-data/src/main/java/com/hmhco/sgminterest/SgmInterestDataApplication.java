package com.hmhco.sgminterest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.hmhco.sgminterest.domain.User;

@SpringBootApplication
@ComponentScan("com.hmhco")
public class SgmInterestDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(SgmInterestDataApplication.class, args);

	}
}
