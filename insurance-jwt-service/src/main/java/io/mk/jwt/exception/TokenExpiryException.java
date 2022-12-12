package io.mk.jwt.exception;

public class TokenExpiryException extends RuntimeException {

	public TokenExpiryException(String message) {
		super(message);
	}

}
