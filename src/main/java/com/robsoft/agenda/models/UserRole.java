package com.robsoft.agenda.models;

public class UserRole {
private int userRoleId;
	
	private User user;
	private String role;

	public UserRole(User user, String role) {
		super();
		this.user = user;
		this.role = role;
	}
	
	public UserRole() {}

	public int getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
