package com.hmhco.sgminterest.service;

import java.util.ArrayList;
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

import com.hmhco.sgminterest.domain.Book;
import com.hmhco.sgminterest.domain.Profile;
import com.hmhco.sgminterest.domain.Recommendation;
import com.hmhco.sgminterest.domain.User;

@Service
public class RecommendationServiceImpl implements RecommendationService{
	
	@Autowired
	private RestTemplate baseRestTemplate;
	
	@Value("${data.baseUri}")
	private String dataServiceBaseUri;

	@Override
	public List<Recommendation> getRecommendations(User survey) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Object> httpEntity = new HttpEntity<Object>(survey, headers);
		ResponseEntity<List<Profile>> response = baseRestTemplate.exchange(dataServiceBaseUri + "/create", HttpMethod.POST, httpEntity, new ParameterizedTypeReference<List<Profile>>(){});
		
		Book b1 = new Book("1","Being an Artist", "Artist");
		List<Book> bookList = new ArrayList<>();
		bookList.add(b1);
		
		Recommendation r1 = new Recommendation(response.getBody(), bookList);
		List<Recommendation> rList = new ArrayList<Recommendation>();
		rList.add(r1);
		//ResponseEntity<User> response = baseRestTemplate.exchange(dataServiceBaseUri + "/create", HttpMethod.POST, httpEntity, User.class);
		
		return rList;
	}

}
