package io.mk.jwt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class JwtExceptionHandler {

	@ExceptionHandler(value = TokenExpiryException.class)
	public ResponseEntity<ErrorResponse> handleTokenExpiryException(TokenExpiryException e) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage());
		ResponseEntity<ErrorResponse> re = new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
		return re;
	}

}
