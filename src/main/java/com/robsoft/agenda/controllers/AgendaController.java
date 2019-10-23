package com.robsoft.agenda.controllers;

import java.security.Security;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.robsoft.agenda.constants.ViewConstants;
import com.robsoft.agenda.converters.UserConverter;
import com.robsoft.agenda.models.Appointment;
import com.robsoft.agenda.models.User;
import com.robsoft.agenda.services.AppointmentService;
import com.robsoft.agenda.services.impl.UserService;

@Controller
@RequestMapping("/agenda")
public class AgendaController {

	private static final Log LOG = LogFactory.getLog(AgendaController.class);

	@Autowired
	@Qualifier("appointmentService")
	private AppointmentService appointmentService;
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@GetMapping("")
	public String index(Model model) {
		List<Appointment> appointments = null;
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		appointments = appointmentService.allByUsernameAndActive(username, true);
		model.addAttribute("appointments", appointments);
		return ViewConstants.AGENDA_INDEX;
	}
	
	@GetMapping("/new")
	public String storeForm(Model model) {
		model.addAttribute("appointment", new Appointment());
		return ViewConstants.AGENDA_NEW;
	}

	@GetMapping("/{id}")
	public String show(@PathVariable(name="id", required=true) int id,
			Model model) {
		Appointment appointment = appointmentService.find(id);
		LOG.info("METHOD: show() --PARAMS: appointment:" + appointment);
		
		if (null == appointment) {
			return "redirect:/agenda/new";
		}
		model.addAttribute("appointment", appointment);
		return ViewConstants.AGENDA_EDIT;
	}
	
	@PostMapping("/{id}")
	public String update(@PathVariable(name="id", required=true) int id,
			@ModelAttribute(name="appointment") Appointment appointment,
			Model model) {
		LOG.info("METHOD: update() -- PARAMS: appointment: " + appointment);
		User user = userService.find(appointment.getUsername());
		
		if (null == user) {
			return "redirect:/agenda";
		}
		appointment.setUser(user);
		appointmentService.update(appointment);
		return "redirect:/agenda";
	}
	
	@PostMapping("")
	public String store(@ModelAttribute(name="appointment") Appointment appointment,
			Model model) {
		LOG.info("METHOD: store() -- PARAMS: appointment: " + appointment);
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userService.find(username);
		
		if (null == user) {
			return "redirect:/agenda";
		}
		appointment.setActive(true);
		appointment.setUser(user);
		appointmentService.store(appointment);
		return "redirect:/agenda";
	}
}
