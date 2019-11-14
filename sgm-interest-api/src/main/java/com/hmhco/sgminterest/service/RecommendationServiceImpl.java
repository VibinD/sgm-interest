package com.hmhco.sgminterest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.hmhco.sgminterest.domain.Recommendation;
import com.hmhco.sgminterest.domain.UserSurvey;

public class RecommendationServiceImpl implements RecommendationService{
	
	@Autowired
	private RestTemplate baseRestTemplate;

	@Override
	public List<Recommendation> getRecommendations(UserSurvey survey) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Object> httpEntity = new HttpEntity<Object>(survey, headers);
		ResponseEntity<List<Recommendation>> response = baseRestTemplate.exchange("http://localhost:8081/getUserRecommendations", HttpMethod.POST, httpEntity, new ParameterizedTypeReference<List<Recommendation>>(){});
		
		return response.getBody();
	}

}
