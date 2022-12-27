package io.mk.app2insurance.exception;

public class ItemAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String message;

	public ItemAlreadyExistsException() {
	}

	public ItemAlreadyExistsException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
