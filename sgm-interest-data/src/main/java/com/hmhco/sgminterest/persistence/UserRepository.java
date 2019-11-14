package com.hmhco.sgminterest.persistence;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hmhco.sgminterest.domain.User;


@Repository
public interface UserRepository extends MongoRepository<User, String>{

//	User findOne(Query query, Class<User> class1);
}
