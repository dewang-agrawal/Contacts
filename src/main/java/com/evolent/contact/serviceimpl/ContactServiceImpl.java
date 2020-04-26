package com.evolent.contact.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.evolent.contact.dto.Response;
import com.evolent.contact.model.Contact;
import com.evolent.contact.repository.ContactRepository;
import com.evolent.contact.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	ContactRepository contactRepository;

	@Override
	@Transactional
	public ResponseEntity<Response> saveContact(Contact contact) {
		try {
			contactRepository.save(contact);
			return new ResponseEntity<Response>(new Response("Contact saved successfully"), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<Response>(new Response("Contact failed to save"),
					HttpStatus.UNPROCESSABLE_ENTITY);
		}

	}

	@Override
	@Transactional
	public ResponseEntity<Response> listContact() {
		Response response = new Response();
		try {
			List<Contact> contactList = new ArrayList<Contact>();
			contactList = contactRepository.findAll();
			response.setMessage("Contact List Fetched Successfully");
			response.setObject(contactList);
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		} catch (Exception ex) {
			response.setMessage("Contact list fetching failed");
			return new ResponseEntity<Response>(response, HttpStatus.UNPROCESSABLE_ENTITY);
		}

	}

	@Override
	@Transactional
	public ResponseEntity<Response> deleteContactById(Integer contactId) {
		Response response = new Response();
		try {
			contactRepository.updateContact(contactId);
			response.setMessage("Contact deleted successfully");
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		} catch (Exception ex) {
			response.setMessage("Contact with id:" + contactId + " not deleted");
			return new ResponseEntity<Response>(response, HttpStatus.UNPROCESSABLE_ENTITY);

		}
	}

	@Override
	@Transactional
	public ResponseEntity<Response> getContactById(Integer contactId) {
		Response response = new Response();
		try {
			Contact contact = contactRepository.findById(contactId).get();
			response.setMessage("Contact fetched successfully");
			response.setObject(contact);
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		} catch (Exception ex) {
			response.setMessage("Contact with id:" + contactId + " not found");
			return new ResponseEntity<Response>(response, HttpStatus.UNPROCESSABLE_ENTITY);

		}
	}
}
