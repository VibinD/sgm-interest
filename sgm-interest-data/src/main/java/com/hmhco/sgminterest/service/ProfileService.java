package com.hmhco.sgminterest.service;

import java.util.List;

import com.hmhco.sgminterest.domain.Profile;

public interface ProfileService {

	List<Profile> getProfilesByCategoryAndSubCategory(String category, String subCategory );
	
	public List<Profile> getProfilesByCategoryAndKeywords(String category, List<String> keywords);
}
