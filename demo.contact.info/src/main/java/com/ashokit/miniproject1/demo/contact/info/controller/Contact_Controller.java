package com.ashokit.miniproject1.demo.contact.info.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ashokit.miniproject1.demo.contact.info.entity.Contact;
import com.ashokit.miniproject1.demo.contact.info.service.Contact_Service;

import javassist.NotFoundException;

@Controller
public class Contact_Controller {
	
	private Contact_Service contact_Service;
	
	public Contact_Controller(Contact_Service contact_Service) {
	
		this.contact_Service = contact_Service;
	}
	
	@GetMapping("/showall")
	public String showAll(Model model, HttpServletRequest req){
		
		Integer pagesize = 3;
		Integer pageNo =  1;
		
		String parameter = req.getParameter("pno");
		if(parameter!=null) {
			
			pageNo = Integer.parseInt(parameter);
			System.out.println(pageNo);
		}
		
		Page<Contact> findAll = contact_Service.findAll(pageNo-1, pagesize);
		List<Contact> content = findAll.getContent();
		int totalPages = findAll.getTotalPages();
		
		model.addAttribute("contact", content);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("pagesize", pagesize);
		model.addAttribute("totalpages", totalPages);
		model.addAttribute("currentpageno", pageNo);
		
		
		return "allContacts";
	}
	
	
	@PostMapping("/save")
	public String save(Contact contact) {
		if(contact_Service.save(contact)) {
			
		return "redirect:/";
		}
		else return "addContact";
	}
	
	
	@GetMapping("/update")
	public String update(@RequestParam Integer id, Model model) throws NotFoundException {
		 Contact findbyId = contact_Service.findbyId(id);
		 if(findbyId!=null) {
			 
		model.addAttribute("edit", findbyId);
		return "update";
		 }
		return "redirect:/";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam Integer ids) throws NotFoundException {
	Contact contact = contact_Service.findbyId(ids);
	contact_Service.deleteContact(contact);
	
	
	return "redirect:/showall";
		
	}

}
