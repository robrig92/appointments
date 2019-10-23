package com.robsoft.agenda.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Appointment {

	private int id;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date date;
	@DateTimeFormat(pattern="HH:mm")
	private Date time;
	private String description;
	private String priority;
	private boolean active;
	private User user;
	private String username;

	public Appointment() {
		super();
	}

	public Appointment(int id, Date date, Date time, String description, String priority, boolean active, User user) {
		super();
		this.id = id;
		this.date = date;
		this.time = time;
		this.description = description;
		this.priority = priority;
		this.active = active;
		this.user = user;
	}
	
	public Appointment(int id, Date date, Date time, String description, String priority, boolean active) {
		super();
		this.id = id;
		this.date = date;
		this.time = time;
		this.description = description;
		this.priority = priority;
		this.active = active;
	}

	public Appointment(Date date, Date time, String description, String priority, boolean active) {
		super();
		this.date = date;
		this.time = time;
		this.description = description;
		this.priority = priority;
		this.active = active;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", date=" + date + ", time=" + time + ", description=" + description
				+ ", priority=" + priority + ", active=" + active + ", user=" + user + ", username=" + username + "]";
	}
}
