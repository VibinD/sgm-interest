package com.hmhco.sgminterest.service.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HttpRestServiceImpl implements HttpRestService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public Object getForObject(String url, Class<Object> responseType, Object... uriVariables) {
		return restTemplate.getForObject(url, responseType, uriVariables);
	}

}
