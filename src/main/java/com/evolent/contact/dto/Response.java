package com.evolent.contact.dto;

public class Response {
	private String message;
	private Object object;

	public Response(String message) {
		super();
		this.message = message;
	}

	public Response() {
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
