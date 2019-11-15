package com.hmhco.sgminterest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hmhco.sgminterest.domain.Question;
import com.hmhco.sgminterest.domain.User;
import com.hmhco.sgminterest.domain.Profile;
import com.hmhco.sgminterest.persistence.ProfileDAOImpl;
import com.hmhco.sgminterest.persistence.ProfileRepository;
import com.hmhco.sgminterest.persistence.UserRepository;

@Service
public class ProfileServiceImpl implements ProfileService{

	@Autowired
	private ProfileRepository profileRepository;
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ProfileDAOImpl profileDAO;

	
	@Override
	public List<Profile> getProfilesByCategoryAndSubCategory(String category, String subCategory) {
		List<Profile> profiles = profileRepository.findByCategoryAndSubCategory(category, subCategory);	
		return profiles;		
	}

	@Override
	public List<Profile> getProfiles(User user) {
		userRepository.save(user);
		List<Question> questions = user.getQuestions();
		if(questions != null && questions.size() > 0 ) {
			String category = questions.get(0).getAnswer();
			String subCategory = questions.get(0).getLabel();
			return getProfilesByCategoryAndSubCategory(category, subCategory);
		} else
			return new ArrayList<Profile>();
		
	}

	public List<Profile> getProfilesByCategoryAndKeywords(String category, List<String> keywords) {
		List<Profile> profiles = profileDAO.getProfileByCategoryAndKeywords(category, keywords);
		return profiles;		
	}

	@Override
	public void saveProfile(Profile profile) {
		profileRepository.save(profile);
		
	}

	
}
