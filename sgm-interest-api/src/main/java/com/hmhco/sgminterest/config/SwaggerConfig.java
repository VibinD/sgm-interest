package com.hmhco.sgminterest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build().apiInfo(apiInfo());
	}

	protected ApiInfo apiInfo() {
		Contact contact = contact();

		ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
		apiInfoBuilder.title("SGM Recommendations By Interest Service");
		apiInfoBuilder.description("This microservice provides api for integrating to get Recommendations By Interests.");
		apiInfoBuilder.version("0.0.1");
		apiInfoBuilder.contact(contact);

		ApiInfo apiInfo = apiInfoBuilder.build();
		return apiInfo;
	}

	protected Contact contact() {
		Contact contact = new Contact("SGM Recommendations By Interest Service","", null);
		return contact;
	}

}
