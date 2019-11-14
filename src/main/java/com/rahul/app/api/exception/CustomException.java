package com.rahul.app.api.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


/**
 * @author Rahul
 *
 */
@Getter
@Setter
@AllArgsConstructor
public class CustomException extends RuntimeException {
	/**
	* 
	*/
	private static final long serialVersionUID = 9053404906314614626L;

	private String errorMessage;
	private String details;

	
}