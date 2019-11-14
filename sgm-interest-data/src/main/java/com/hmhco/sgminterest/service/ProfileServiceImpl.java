package com.hmhco.sgminterest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hmhco.sgminterest.domain.Question;
import com.hmhco.sgminterest.domain.User;
import com.hmhco.sgminterest.persistence.Profile;
import com.hmhco.sgminterest.persistence.ProfileRepository;
import com.hmhco.sgminterest.persistence.UserRepository;

@Service
public class ProfileServiceImpl implements ProfileService{

	@Autowired
	private ProfileRepository profileRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<Profile> getProfilesByCategoryAndSubCategory(String category, String subCategory) {
		List<Profile> profiles = profileRepository.findByCategoryAndSubCategory(category, subCategory);	
		return profiles;		
	}

	@Override
	public List<Profile> getProfiles(User user) {
		userRepository.save(user);
		List<Question> questions = user.getQuestions();
		String category = questions.get(0).getAnswer();
		String subCategory = questions.get(1).getAnswer();
		return getProfilesByCategoryAndSubCategory(category, subCategory);
	}

	
}
