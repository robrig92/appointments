package com.robsoft.agenda.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.robsoft.agenda.models.Appointment;

@Component("appointmentConverter")
public class AppointmentConverter {

	@Autowired
	@Qualifier("userConverter")
	private UserConverter userConverter;
	
	public Appointment toModel(com.robsoft.agenda.entities.Appointment appointment) {
		Appointment model = new Appointment();
		
		model.setId(appointment.getId());
		model.setDate(appointment.getDate());
		model.setTime(appointment.getTime());
		model.setDescription(appointment.getDescription());
		model.setPriority(appointment.getPriority());
		model.setActive(appointment.isActive());
		model.setUser(userConverter.toModel(appointment.getUser()));
		model.setUsername(appointment.getUsername());
		return model;
	}
	
	public com.robsoft.agenda.entities.Appointment toEntity(Appointment appointment) {
		com.robsoft.agenda.entities.Appointment entity = new com.robsoft.agenda.entities.Appointment();
		
		entity.setId(appointment.getId());
		entity.setDate(appointment.getDate());
		entity.setTime(appointment.getTime());
		entity.setDescription(appointment.getDescription());
		entity.setPriority(appointment.getPriority());
		entity.setActive(appointment.isActive());
		entity.setUser(userConverter.toEntity(appointment.getUser()));
		entity.setUsername(appointment.getUsername());
		return entity;
	}
	
}
