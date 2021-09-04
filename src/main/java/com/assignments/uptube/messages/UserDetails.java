package com.assignments.uptube.messages;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UserDetails implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4227106316813949955L;

	
	private String userId;
	
	private Integer totalLikes=0;
	
	@NotBlank
	private String userName;

	@NotNull
	private LocalDate birthDate;

	@NotBlank
	private String profilePictureUrl;

	
	
	public Integer getTotalLikes() {
		return totalLikes;
	}

	public void setTotalLikes(Integer totalLikes) {
		this.totalLikes = totalLikes;
	}

	public UserDetails() {
		super();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getProfilePictureUrl() {
		return profilePictureUrl;
	}

	public void setProfilePictureUrl(String profilePictureUrl) {
		this.profilePictureUrl = profilePictureUrl;
	}
}
