package com.hmhco.sgminterest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hmhco.sgminterest.persistence.Profile;
import com.hmhco.sgminterest.persistence.ProfileRepository;

@Service
public class ProfileServiceImpl implements ProfileService{

	@Autowired
	private ProfileRepository profileRepository;
	
	@Override
	public List<Profile> getProfilesByCategoryAndSubCategory(String category, String subCategory) {
		List<Profile> profiles = profileRepository.findByCategoryAndSubCategory(category, subCategory);	
		return profiles;		
	}

	
}
