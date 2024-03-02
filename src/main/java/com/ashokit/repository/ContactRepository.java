package com.ashokit.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Serializable> {
	
	
	

}
