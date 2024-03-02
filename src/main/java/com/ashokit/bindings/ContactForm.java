package com.ashokit.bindings;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ContactForm {

	private Integer cotactId;
	private String contactName;
	private String contactEmail;
	private Long contactNumber;
	private String activesw;
	private LocalDate createdDate;
	private LocalDate updatedDate;

}
