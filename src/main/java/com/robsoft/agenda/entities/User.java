package com.robsoft.agenda.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {

	@Id
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="active")
	private boolean active;
	
	@OneToMany(fetch = FetchType.EAGER)
	private Set<UserRole> userRole = new HashSet<UserRole>();

	@OneToMany(fetch=FetchType.EAGER)
	private List<Appointment> appointments;
	
	public User(String username, String password, boolean active, Set<UserRole> userRole) {
		super();
		this.username = username;
		this.password = password;
		this.active = active;
		this.userRole = userRole;
	}

	public User() {
		super();
	}

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
}
