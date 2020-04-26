package com.evolent.contact.service;

import org.springframework.http.ResponseEntity;

import com.evolent.contact.dto.Response;
import com.evolent.contact.model.Contact;

public interface ContactService {

	public ResponseEntity<Response> saveContact(Contact contact);

	public ResponseEntity<Response> listContact();

	public ResponseEntity<Response> deleteContactById(Integer contactId);

	public ResponseEntity<Response> getContactById(Integer contactId);
}
