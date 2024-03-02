package com.ashokit.service;

import java.util.List;

import com.ashokit.bindings.ContactForm;

public interface ContactService {
	public String saveContact ( ContactForm form);
	
	public List <ContactForm> viewContacts();
	
	public ContactForm editContact(Integer ContactId);
	
	public List<ContactForm> deleteContact(Integer contactId);
	 
     
	
}
