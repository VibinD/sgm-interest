package com.hmhco.sgminterest.service.rest;

public interface HttpRestService {
	
	Object getForObject(String url, Class<Object> responseType, Object... uriVariables);

}
