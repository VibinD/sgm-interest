package com.hmhco.sgminterest.service;

import java.util.List;
import com.hmhco.sgminterest.domain.User;
import com.hmhco.sgminterest.domain.Profile;


public interface ProfileService {

	List<Profile> getProfilesByCategoryAndSubCategory(String category, String subCategory );
	
	List<Profile> getProfiles(User user);

	public List<Profile> getProfilesByCategoryAndKeywords(String category, List<String> keywords);
	
	void saveProfile(Profile profile);

}
