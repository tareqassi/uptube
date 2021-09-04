package com.assignments.uptube.daos;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.assignments.uptube.models.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	
	public User findByUserName(String userName);
	
	public User findByUserId(String userId);

	public List<User> findByUserIdIn(List<String> ids);

}
