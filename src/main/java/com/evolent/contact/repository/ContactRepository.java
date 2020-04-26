package com.evolent.contact.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.evolent.contact.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

	@Modifying
	@Query("UPDATE Contact c SET c.status = 'inactive' WHERE c.id = :contactId")
	int updateContact(@Param("contactId") Integer contactId);

	@Query("SELECT c FROM Contact c where c.status = 'active' ")
	List<Contact> findAll();

	@Query("SELECT c FROM Contact c where c.status = 'active' and c.id = :contactId")
	Optional<Contact> findById(@Param("contactId") Integer contactId);

}
