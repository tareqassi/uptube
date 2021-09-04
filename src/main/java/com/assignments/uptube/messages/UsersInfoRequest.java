package com.assignments.uptube.messages;

import java.io.Serializable;
import java.util.List;

public class UsersInfoRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8093871709167234027L;
	private List<String> userIds;

	public UsersInfoRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<String> getUserIds() {
		return userIds;
	}

	public void setUserIds(List<String> userIds) {
		this.userIds = userIds;
	}
	
	

}
