package com.evolent.contact.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.evolent.contact.dto.Response;
import com.evolent.contact.model.Contact;
import com.evolent.contact.service.ContactService;

@RestController
public class ContactController {

	@Autowired
	ContactService contactService;

	@PostMapping("/addContact")
	public ResponseEntity<Response> addContact(@RequestBody Contact contact) {
		contact.setStatus("active");
		return contactService.saveContact(contact);
	}

	@GetMapping("/listContacts")
	public ResponseEntity<Response> getAllContact() {
		return contactService.listContact();
	}

	@PutMapping("/updateContact")
	public ResponseEntity<Response> updateContact(@RequestBody Contact contact) {
		return contactService.saveContact(contact);
	}

	@DeleteMapping("/deleteContact/{contactId}")
	public ResponseEntity<Response> deleteContact(@PathVariable Integer contactId) {
		return contactService.deleteContactById(contactId);
	}

	@GetMapping("/getContact/{contactId}")
	public ResponseEntity<Response> getContactById(@PathVariable Integer contactId) {
		return contactService.getContactById(contactId);
	}

}
