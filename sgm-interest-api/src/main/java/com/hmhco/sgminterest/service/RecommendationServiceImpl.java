package com.hmhco.sgminterest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hmhco.sgminterest.domain.Recommendation;
import com.hmhco.sgminterest.domain.UserSurvey;

@Service
public class RecommendationServiceImpl implements RecommendationService{
	
	@Autowired
	private RestTemplate baseRestTemplate;
	
	@Value("${data.baseUri}")
	private String dataServiceBaseUri;

	@Override
	public List<Recommendation> getRecommendations(UserSurvey survey) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Object> httpEntity = new HttpEntity<Object>(survey, headers);
		ResponseEntity<List<Recommendation>> response = baseRestTemplate.exchange(dataServiceBaseUri + "/create", HttpMethod.POST, httpEntity, new ParameterizedTypeReference<List<Recommendation>>(){});
		
		return response.getBody();
	}

}
