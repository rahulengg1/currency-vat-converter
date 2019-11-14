package com.rahul.app.api.response;

import java.time.LocalTime;

import lombok.Data;

/**
 * @author Rahul
 *
 */
@Data
public class CurrentTimeResponseObject {
	
	private LocalTime currentTime;

}
