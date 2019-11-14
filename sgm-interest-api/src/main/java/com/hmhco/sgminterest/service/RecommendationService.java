package com.hmhco.sgminterest.service;

import java.util.List;

import com.hmhco.sgminterest.domain.Recommendation;
import com.hmhco.sgminterest.domain.UserSurvey;

public interface RecommendationService {
	public List<Recommendation> getRecommendations(UserSurvey survey);
}	
