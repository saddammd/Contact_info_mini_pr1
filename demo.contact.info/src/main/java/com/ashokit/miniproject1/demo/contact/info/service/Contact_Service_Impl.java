package com.ashokit.miniproject1.demo.contact.info.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ashokit.miniproject1.demo.contact.info.dao.Contact_dao;
import com.ashokit.miniproject1.demo.contact.info.entity.Contact;

import javassist.NotFoundException;

@Service
public class Contact_Service_Impl implements Contact_Service {
	
	private Contact_dao contact_dao;
	
	@Autowired
	public Contact_Service_Impl(Contact_dao contact_dao) {
		this.contact_dao = contact_dao;
	}

	/*
	 * @Override public List<Contact> findAll() {
	 * 
	 * Contact contact = new Contact(); contact.setDeleted(false);
	 * 
	 * Example<Contact> ct = Example.of(contact);
	 * 
	 * return contact_dao.findAll(ct); }
	 */

	
	@Override
	public Page<Contact> findAll(int pageNo, int pageSize) {
		
		Contact contact = new Contact();
		contact.setDeleted(false);
		
		Example<Contact> ct = Example.of(contact);
		
		PageRequest pagerequest = PageRequest.of(pageNo, pageSize);
		
		Page<Contact> findAll = contact_dao.findAll(ct, pagerequest);
		
		return findAll;
	}
	
	
	@Override
	public Contact findbyId(Integer Contact_id) throws NotFoundException {
		
		if(contact_dao.getById(Contact_id)!=null) {
			return contact_dao.getById(Contact_id);
		}
		
		else throw new NotFoundException("Contact Not Found");
	}
	

	@Override
	public boolean save(Contact contact) {
		
		if(((contact.getName()!=null) && (contact.getEmail()!= null) && (contact.getNumber()!=null)))
				{
			contact.setDeleted(false);
			contact_dao.save(contact);
			return true;
		}
		
		return false;
	}

	@Override
	public boolean deleteContact(Contact contact) {
		
		contact.setDeleted(true);
		contact_dao.save(contact);
		
		return true;
		}

	

		

}
