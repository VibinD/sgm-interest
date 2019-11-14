package com.hmhco.sgminterest.service;

import java.util.List;

import com.hmhco.sgminterest.domain.Recommendation;
import com.hmhco.sgminterest.domain.User;

public interface RecommendationService {
	public List<Recommendation> getRecommendations(User user);
}	
