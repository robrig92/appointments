package com.robsoft.agenda.converters;

import org.springframework.stereotype.Component;

import com.robsoft.agenda.entities.User;

@Component("userConverter")
public class UserConverter {
	
	public User toEntity(com.robsoft.agenda.models.User user) {
		User entity = new User();
		
		entity.setUsername(user.getUsername());
		entity.setPassword(user.getPassword());
		entity.setActive(user.isActive());
		
		return entity;
	}
	
	public com.robsoft.agenda.models.User toModel(User user) {
		com.robsoft.agenda.models.User model = new com.robsoft.agenda.models.User();
		
		model.setUsername(user.getUsername());
		model.setPassword(user.getPassword());
		model.setActive(user.isActive());
		
		return model;
	}
}
