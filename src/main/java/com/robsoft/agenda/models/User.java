package com.robsoft.agenda.models;

import java.util.HashSet;
import java.util.Set;

public class User {
private String username;
	
	private String password;
	private boolean active;
	private Set<UserRole> userRole = new HashSet<UserRole>();

	public User(String username, String password, boolean active, Set<UserRole> userRole) {
		super();
		this.username = username;
		this.password = password;
		this.active = active;
		this.userRole = userRole;
	}

	public User(String username, String password, boolean active) {
		super();
		this.username = username;
		this.password = password;
		this.active = active;
	}
	
	public User() {}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Set<UserRole> getUserRole() {
		return userRole;
	}

	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", active=" + active + ", userRole=" + userRole
				+ "]";
	}
}
