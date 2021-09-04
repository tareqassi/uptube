package com.assignments.uptube.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.assignments.uptube.errors.exceptions.ResourceDoesNotExistException;
import com.assignments.uptube.mappers.UserMapper;
import com.assignments.uptube.messages.AddNewUserRequest;
import com.assignments.uptube.messages.UpdateUserRequest;
import com.assignments.uptube.messages.UserDetails;
import com.assignments.uptube.messages.UsersInfoRequest;
import com.assignments.uptube.models.User;
import com.assignments.uptube.services.UserService;

@RestController
@RequestMapping("/v1/user")
public class UserController {

	@Autowired
	private UserService userService;

	private UserMapper userMapper = UserMapper.INSTANCE;

	/**
	 * Get User By ID
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/getUserDetails/{userId}", method = RequestMethod.GET)
	public ResponseEntity<UserDetails> getUserByUserId(@PathVariable(name = "userId", required = true) String userId) {
		User user = userService.findByUserId(userId);
		if (user == null) {
			throw new ResourceDoesNotExistException("Not Found");
		} else {
			return new ResponseEntity<UserDetails>(userMapper.fromEntity(user), HttpStatus.OK);
		}
	}

	/**
	 * Get Users By User IDs list
	 * 
	 * @param userinforequest
	 * @return
	 */
	@RequestMapping(value ="/retrieveUsersInfoByIds" ,method = RequestMethod.GET)
	public ResponseEntity<List<UserDetails>> getUserInfos(@RequestBody UsersInfoRequest userinforequest) {
		List<User> users = userService.findByUserIdsIn(userinforequest.getUserIds());
		if (users == null || users.isEmpty()) {
			throw new ResourceDoesNotExistException("Not Found");
		} else {
			return new ResponseEntity<List<UserDetails>>(userMapper.fromEntities(users), HttpStatus.OK);
		}
	}

	/**
	 * Get User By Username
	 * 
	 * @param userName
	 * @return
	 */
	@RequestMapping(value = "/byusername/{userName}", method = RequestMethod.GET)
	public ResponseEntity<UserDetails> getUserByUserName(
			@PathVariable(name = "userName", required = true) String userName) {
		User user = userService.findByUserName(userName);
		if (user == null) {
			throw new ResourceDoesNotExistException("Not Found");
		} else {
			return new ResponseEntity<UserDetails>(userMapper.fromEntity(user), HttpStatus.OK);
		}
	}

	/**
	 * Delete user by user ID
	 * 
	 * @param userId
	 */
	@RequestMapping(value = "/deleteUser/{userId}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable(name = "userId", required = true) String userId) {

		User user = userService.findByUserId(userId);
		if (user == null) {
			throw new ResourceDoesNotExistException("Not Found");
		} else {
			userService.deleteByUserId(user.getUserId());
		}
	}

	/**
	 * Add New User
	 * 
	 * @param newUser
	 * @return
	 */
	@RequestMapping(value = "/addNewUser",method = RequestMethod.POST)
	public ResponseEntity<UserDetails> addNewUser(@Valid @RequestBody AddNewUserRequest newUser) {
		User user = userService.save(userMapper.toEntity(newUser));
		return new ResponseEntity<UserDetails>(userMapper.fromEntity(user), HttpStatus.OK);
	}

	/**
	 * Update User Info
	 * 
	 * @param newUser
	 * @return
	 */
	@RequestMapping(value = "/updateUser/{userId}", method = RequestMethod.PUT)
	public ResponseEntity<UserDetails> updateUser(@PathVariable(name = "userId", required = true) String userId,
			@Valid @RequestBody UpdateUserRequest newUser) {
		User user = userService.findByUserId(userId);
		if (user == null) {
			throw new ResourceDoesNotExistException("Not Found");
		} else {
			User updateuser = userMapper.toEntity(newUser);
			updateuser.setUserId(user.getUserId());
			updateuser=userService.save(updateuser);
			return new ResponseEntity<UserDetails>(userMapper.fromEntity(updateuser), HttpStatus.OK);
		}
	}

}
