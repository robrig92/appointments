package com.robsoft.agenda.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.robsoft.agenda.constants.ViewConstants;
import com.robsoft.agenda.models.User;
import com.robsoft.agenda.services.impl.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@GetMapping("")
	public String showForm() {
		return ViewConstants.LOGIN;
	}
	
	@GetMapping({"/success", "/"})
	public String success() {
		return "redirect:/agenda";
	}
	
	@GetMapping("/initialize")
	public String initialize() {
		userService.store(new User("admin", "admin", true));
		return "redirect:/login";
	}
}
