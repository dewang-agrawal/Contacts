package com.evolent.contact.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import com.evolent.contact.ContactsApplication;
import com.evolent.contact.dto.Response;
import com.evolent.contact.model.Contact;
import com.evolent.contact.repository.ContactRepository;
import com.evolent.contact.serviceimpl.ContactServiceImpl;

@ContextConfiguration(classes = ContactsApplication.class)
@RunWith(MockitoJUnitRunner.class)
public class ContactserviceTest {

	@InjectMocks
	ContactServiceImpl contactService;

	@Mock
	ContactRepository contactRepository;

	@Test
	public void addContactSuccessTest() {
		Contact contact = new Contact("Sachin", "Sharma", "sachin_sharma@gmail.com", "9123456780", "active");
		when(contactRepository.save(contact)).thenReturn(contact);
		ResponseEntity<Response> responseEntity = contactService.saveContact(contact);
		assertEquals(responseEntity.getBody().getMessage(), "Contact saved successfully");
		assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
	}

	@Test
	public void addContactfailTest() {
		Contact contact = new Contact("Sachin", "Sharma", "sachin_sharma@gmail.com", "9123456780", "active");
		when(contactRepository.save(contact)).thenThrow(MockitoException.class);
		ResponseEntity<Response> responseEntity = contactService.saveContact(contact);
		assertEquals(responseEntity.getBody().getMessage(), "Contact failed to save");
		assertEquals(responseEntity.getStatusCode(), HttpStatus.UNPROCESSABLE_ENTITY);
	}

	@Test
	public void listContactTest() {
		Contact contact = new Contact("Sachin", "Sharma", "sachin_sharma@gmail.com", "9123456780", "active");
		List<Contact> list = new ArrayList<Contact>();
		list.add(contact);
		when(contactRepository.findAll()).thenReturn(list);
		ResponseEntity<Response> responseEntity = contactService.listContact();
		assertEquals((List<Contact>) responseEntity.getBody().getObject(), list);
		assertEquals(responseEntity.getBody().getMessage(), "Contact List Fetched Successfully");
		assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
	}

	@Test
	public void listContactFailTest() {
		Contact contact = new Contact("Sachin", "Sharma", "sachin_sharma@gmail.com", "9123456780", "active");
		List<Contact> list = new ArrayList<Contact>();
		list.add(contact);
		when(contactRepository.findAll()).thenThrow(MockitoException.class);
		ResponseEntity<Response> responseEntity = contactService.listContact();
		assertEquals(responseEntity.getBody().getMessage(), "Contact list fetching failed");
		assertEquals(responseEntity.getStatusCode(), HttpStatus.UNPROCESSABLE_ENTITY);
	}

	@Test
	public void updateContactTest() {
		Contact contact = new Contact("Sachin", "Sharma", "sachin_sharma@gmail.com", "9123456780", "active");
		when(contactRepository.save(contact)).thenReturn(contact);
		ResponseEntity<Response> responseEntity = contactService.saveContact(contact);
		assertEquals(responseEntity.getBody().getMessage(), "Contact saved successfully");
		assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
	}

	@Test
	public void updateContactTest2() {
		Contact contact = new Contact("Sachin", "Sharma", "sachin_sharma@gmail.com", "9123456780", "active");
		when(contactRepository.save(contact)).thenThrow(MockitoException.class);
		ResponseEntity<Response> responseEntity = contactService.saveContact(contact);
		assertEquals(responseEntity.getBody().getMessage(), "Contact failed to save");
		assertEquals(responseEntity.getStatusCode(), HttpStatus.UNPROCESSABLE_ENTITY);
	}
}
