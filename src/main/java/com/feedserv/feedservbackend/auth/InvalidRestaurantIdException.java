package com.feedserv.feedservbackend.auth;

public class InvalidRestaurantIdException extends Exception {
	private static final long serialVersionUID = 8918579399493197358L;

	public InvalidRestaurantIdException() {
		super();
	}

	public InvalidRestaurantIdException(String message) {
		super(message);
	}

}
