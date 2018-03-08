package com.feedserv.feedservbackend.auth;

public class InvalidRegistrationDataException extends Exception {

	private static final long serialVersionUID = 1208915408326278837L;

	public InvalidRegistrationDataException() {
		super();
	}

	public InvalidRegistrationDataException(String message) {
		super(message);
	}

}
