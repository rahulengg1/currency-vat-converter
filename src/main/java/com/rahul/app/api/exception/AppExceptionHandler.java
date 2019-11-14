package com.rahul.app.api.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.rahul.app.api.shared.ErrorMessage;

/**
 * @author Rahul
 *
 */
@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request) {

		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setTimeStamp(new Date());

		List<String> error = new ArrayList<String>();

		if (ex instanceof CustomException) {
			error.add(((CustomException) ex).getErrorMessage());
			errorMessage.setStatus(HttpStatus.NOT_FOUND.value());
		} else {
			error.add(ex.getMessage());
			errorMessage.setStatus(HttpStatus.BAD_REQUEST.value());
		}
		errorMessage.setError(error);

		if (ex instanceof CustomException) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
		}

	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setTimeStamp(new Date());
		errorMessage.setStatus(status.value());

		// Get all errors
		List<String> errors = ex.getBindingResult().getAllErrors().stream().map(loop -> loop.getDefaultMessage())
				.collect(Collectors.toList());

		errorMessage.setError(errors);

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(headers).body(errorMessage);

	}

}
