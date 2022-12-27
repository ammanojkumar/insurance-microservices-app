package io.mk.app2insurance.exception;

public class ErrorResponse {

	private String message;
	private String error;

	public ErrorResponse(String message, String error) {
		super();
		this.message = message;
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
