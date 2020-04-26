package com.evolent.contact.model;

public enum ContactStatus {

	ACTIVE("active"), INACTIVE("inactive");

	private String name;

	private ContactStatus(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}
