package com.ashokit.miniproject1.demo.contact.info.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ashokit.miniproject1.demo.contact.info.entity.Contact;

import javassist.NotFoundException;

public interface Contact_Service {
	
	public Contact findbyId(Integer Contact_id) throws NotFoundException;
	public boolean save(Contact contact);
	boolean deleteContact(Contact contact);
	public Page<Contact> findAll(int pageNo, int pageSize);
	


}
