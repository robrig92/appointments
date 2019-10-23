package com.robsoft.agenda.services;

import java.util.List;

import com.robsoft.agenda.models.Appointment;

public interface AppointmentService {

	public abstract List<Appointment> allByUsernameAndActive(String username, boolean active);
	public abstract Appointment find(int id);
	public abstract Appointment store(Appointment appointment);
	public abstract Appointment update(Appointment appointment);
	
}
