package com.robsoft.agenda.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.robsoft.agenda.constants.ViewConstants;
import com.robsoft.agenda.models.User;
import com.robsoft.agenda.services.impl.UserService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@GetMapping("/new")
	public String showForm(Model model) {
		model.addAttribute("user", new User());
		return ViewConstants.USER_NEW;
	}
	
	@PostMapping("")
	public String store(@ModelAttribute(name="user") User user) {
		user.setActive(true);
		userService.store(user);
		return "redirect:/agenda";
	}
}
