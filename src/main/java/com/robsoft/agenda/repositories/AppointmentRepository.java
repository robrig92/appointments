package com.robsoft.agenda.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.robsoft.agenda.entities.Appointment;

@Repository("appointmentRepository")
public interface AppointmentRepository extends JpaRepository<Appointment, Serializable> {

	public abstract Appointment findById(int id);
	public abstract List<Appointment> findAllByActive(boolean active);
	public abstract List<Appointment> findAllByUsernameAndActive(String username, boolean active);
}
