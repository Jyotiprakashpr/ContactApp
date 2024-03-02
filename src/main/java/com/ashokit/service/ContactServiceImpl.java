package com.ashokit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.bindings.ContactForm;
import com.ashokit.entities.Contact;
import com.ashokit.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {
	@Autowired
	private ContactRepository contactRepo;

	@Override
	public String saveContact(ContactForm form) {

		// We have recieved form binding object
		// Repository save method expecting entity object
		// so copy the data from form binding object to entity object

		Contact entity = new Contact();
	
		BeanUtils.copyProperties(form, entity);
		entity.setActivesw("Y");
		entity = contactRepo.save(entity);
		if (entity.getCotactId() != null) {
			return "SUCCESS";
		}
		return "FAILURE";
	}

	@Override
	public List<ContactForm> viewContacts() {
		List<ContactForm> dataList = new ArrayList<>();

		List<Contact> findAll = contactRepo.findAll();

		for (Contact entity : findAll) {
			ContactForm form = new ContactForm();
			BeanUtils.copyProperties(entity, form);
			dataList.add(form);
		}
		return dataList;
	}

	@Override
	public ContactForm editContact(Integer ContactId) {
		Optional<Contact> findById = contactRepo.findById(ContactId);
		if (findById.isPresent()) {
			Contact entity = findById.get();
			ContactForm form = new ContactForm();
			BeanUtils.copyProperties(entity, form);
			return form;
		}

		return null;
	}

	@Override
	public List<ContactForm> deleteContact(Integer contactId) {
		contactRepo.deleteById(contactId);
		// getting latest data from table and returning
		List<ContactForm> dataList = new ArrayList<>();

		List<Contact> findAll = contactRepo.findAll();

		for (Contact entity : findAll) {
			ContactForm form = new ContactForm();
			BeanUtils.copyProperties(entity, form);
			dataList.add(form);
		}
		return dataList;
	}

}
