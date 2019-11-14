package com.hmhco.sgminterest.service;

import java.util.List;

import com.hmhco.sgminterest.persistence.Profile;

public interface ProfileService {

	List<Profile> getProfilesByCategoryAndSubCategory(String category, String subCategory );
}
