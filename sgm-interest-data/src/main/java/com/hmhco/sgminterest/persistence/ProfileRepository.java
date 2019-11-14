package com.hmhco.sgminterest.persistence;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends MongoRepository<Profile, Long> {

	@Query("{ category: { $regex: ?0 } , subCategory:{ $regex: ?1 }}")
	List<Profile> findByCategoryAndSubCategory(String category, String subCategory);
}
