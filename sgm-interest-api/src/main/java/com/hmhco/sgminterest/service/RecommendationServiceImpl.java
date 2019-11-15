package com.hmhco.sgminterest.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hmhco.sgminterest.controller.UserController;
import com.hmhco.sgminterest.domain.Book;
import com.hmhco.sgminterest.domain.Profile;
import com.hmhco.sgminterest.domain.Recommendation;
import com.hmhco.sgminterest.domain.User;

@Service
public class RecommendationServiceImpl implements RecommendationService{
	
	private static final Logger logger = LoggerFactory.getLogger(RecommendationServiceImpl.class);
	
	@Autowired
	private RestTemplate baseRestTemplate;
	
	@Value("${data.baseUri}")
	private String dataServiceBaseUri;

	@Override
	public List<Recommendation> getRecommendations(User survey) {
		
		logger.info("Executing the recommendation for " + survey + " base url " + dataServiceBaseUri);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Object> httpEntity = new HttpEntity<Object>(survey, headers);
		ResponseEntity<List<Profile>> response = baseRestTemplate.exchange(dataServiceBaseUri + "/create", HttpMethod.POST, httpEntity, new ParameterizedTypeReference<List<Profile>>(){});
		
		logger.info("Executing the recommendation response for " + response);
		
		if(response.getStatusCode().equals(HttpStatus.OK) && response.getBody() != null) {
			Book b1 = new Book("1", "Picasso: A Biagraphy", "Artist", "https://images-na.ssl-images-amazon.com/images/I/51juEKg7fZL._SX322_BO1,204,203,200_.jpg");
			Book b2 = new Book("2", "Einstein, Picasso: Space, Time…", "Artist", "https://images-na.ssl-images-amazon.com/images/I/51V4Vi2-tiL._SX331_BO1,204,203,200_.jpg");
			Book b3 = new Book("3", "Je Suis Le Cahier: The Sketchbooks of Picasso", "Artist", "https://images-na.ssl-images-amazon.com/images/I/51S706FMFRL._SX352_BO1,204,203,200_.jpg");
			List<Book> bookList = new ArrayList<>();
			bookList.add(b1);
			bookList.add(b2);
			bookList.add(b3);
			
			Recommendation r1 = new Recommendation(response.getBody(), bookList);
			List<Recommendation> rList = new ArrayList<Recommendation>();
			rList.add(r1);
			
			return rList;
		}
		return null;
	}

}
