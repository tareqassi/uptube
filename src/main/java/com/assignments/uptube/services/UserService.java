package com.assignments.uptube.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignments.uptube.daos.UserRepository;
import com.assignments.uptube.models.User;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User findByUserId(String  userId) {
		return userRepository.findByUserId(userId);
	}
	
	public User findByUserName(String  userName) {
		return userRepository.findByUserName(userName);
	}
	
	public List<User> findByUserIdsIn(List<String> ids){
		return userRepository.findByUserIdIn(ids);
	}
	
	public  void deleteByUserId(String userId) {
		userRepository.deleteById(userId);
	}

	public User save(User newUser) {
		return userRepository.save(newUser);
	}

	public User update(User updatedUser) {
		return userRepository.save(updatedUser);
	}

}
