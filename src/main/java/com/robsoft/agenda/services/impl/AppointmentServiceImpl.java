package com.robsoft.agenda.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.robsoft.agenda.converters.AppointmentConverter;
import com.robsoft.agenda.models.Appointment;
import com.robsoft.agenda.repositories.AppointmentRepository;
import com.robsoft.agenda.services.AppointmentService;

@Service("appointmentService")
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	@Qualifier("appointmentRepository")
	private AppointmentRepository appointmentRepository;
	
	@Autowired
	@Qualifier("appointmentConverter")
	private AppointmentConverter appointmentConverter;
	
	@Override
	public List<Appointment> allByUsernameAndActive(String username, boolean active) {
		List<Appointment> appointments = new ArrayList<Appointment>();
		List<com.robsoft.agenda.entities.Appointment> appointmentEntities = appointmentRepository.findAllByUsernameAndActive(username, active);
		
		for (com.robsoft.agenda.entities.Appointment appointment : appointmentEntities) {
			appointments.add(appointmentConverter.toModel(appointment));
		}
		return appointments;
	}

	@Override
	public Appointment find(int id) {
		return appointmentConverter.toModel(appointmentRepository.findById(id));
	}

	@Override
	public Appointment store(Appointment appointment) {
		return appointmentConverter.toModel(appointmentRepository.save(appointmentConverter.toEntity(appointment)));
	}

	@Override
	public Appointment update(Appointment appointment) {
		return appointmentConverter.toModel(appointmentRepository.save(appointmentConverter.toEntity(appointment)));
	}
	
}
