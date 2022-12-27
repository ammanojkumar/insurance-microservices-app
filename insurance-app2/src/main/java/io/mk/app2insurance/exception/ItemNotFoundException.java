package io.mk.app2insurance.exception;

public class ItemNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String message;

	public ItemNotFoundException() {
	}

	public ItemNotFoundException(String message) {
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
