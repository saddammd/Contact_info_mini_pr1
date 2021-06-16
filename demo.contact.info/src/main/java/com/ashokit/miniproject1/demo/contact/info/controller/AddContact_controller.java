package com.ashokit.miniproject1.demo.contact.info.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ashokit.miniproject1.demo.contact.info.entity.Contact;

@Controller
public class AddContact_controller {
	
	@GetMapping("/")
	public String addContact(@ModelAttribute("add") Contact contact) {
		
		return "addContact";
		
	}

}
