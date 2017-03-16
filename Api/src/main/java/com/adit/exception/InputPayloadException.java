package com.adit.exception;

import java.util.ArrayList;

public class InputPayloadException extends Exception {

	private static final long serialVersionUID = -6082487009262342917L;
	private ArrayList<String> errorMessages;

	public InputPayloadException(ArrayList<String> errorMessages) {
		this.setErrorMessages(errorMessages);
	}

	public InputPayloadException(String errorMessage) {
		this.errorMessages = new ArrayList<String>();
		errorMessages.add(errorMessage);
	}

	public InputPayloadException(String value, String errorMessage) {
		this.errorMessages = new ArrayList<String>();
		errorMessages.add("'" + value + "' - " + errorMessage);
	}

	public ArrayList<String> getErrorMessages() {
		return errorMessages;
	}

	public void setErrorMessages(ArrayList<String> errorMessages) {
		this.errorMessages = errorMessages;
	}
}
