package com.hmhco.sgminterest.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.hmhco.sgminterest.domain.Profile;

@Repository
public class ProfileDAOImpl implements ProfileDAO {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	public List<Profile> getProfileByCategoryAndKeywords(String category, List<String> keywords) {
		Query query = new Query();
		query.addCriteria(Criteria.where("category").is(category));
		query.addCriteria(Criteria.where("description").in(keywords));
		List<Profile> profiles = mongoTemplate.findAll(Profile.class);
		return profiles;
		
	}
}
