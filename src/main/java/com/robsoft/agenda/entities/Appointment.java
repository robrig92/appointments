package com.robsoft.agenda.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "appointments")
public class Appointment {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;

	@Column(name = "time")
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern = "HH:mm")
	private Date time;

	@Column(name = "description")
	private String description;

	@Column(name = "priority")
	private String priority;

	@Column(name = "active")
	private boolean active;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="username", nullable=false)
	private User user;
	
	@Column(name="username", insertable=false, updatable=false)
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

	public Appointment(Date date, Date time, String description, String priority, boolean active, User user) {
		super();
		this.date = date;
		this.time = time;
		this.description = description;
		this.priority = priority;
		this.active = active;
		this.user = user;
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
