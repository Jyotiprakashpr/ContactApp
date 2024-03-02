package com.ashokit.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.bindings.ContactForm;
import com.ashokit.service.ContactService;

@RestController
public class ContactRestController {
	@Autowired
	private ContactService service;

	@PostMapping("/save")
	public String saveContact(@RequestBody ContactForm form) {

		return service.saveContact(form);
	}

	@GetMapping("/contacts")
	public List<ContactForm> viewAllContacts() {
		System.out.println("View all Contact() method Called");
		return service.viewContacts();
	}

	@GetMapping("/edit/{ContactId}")
	public ContactForm editContact(@PathVariable Integer ContactId) {
		return service.editContact(ContactId);
	}

	@DeleteMapping("/delete/{ContactId}")
	public List<ContactForm> deleteContact(@PathVariable Integer ContactId) {
		return service.deleteContact(ContactId);
	}
}
