package com.rahul.app.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.app.api.response.CurrentTimeResponseObject;
import com.rahul.app.api.service.CurrentTimeService;

import io.swagger.annotations.Api;

/**
 * @author Rahul
 *
 */
@Api(tags = "Current Time")
@RestController
@RequestMapping("/api")
public class CurrentTimeController {

	CurrentTimeService currentTimeService;
	
	
	
	public CurrentTimeController(CurrentTimeService currentTimeService) {
		super();
		this.currentTimeService = currentTimeService;
	}



	@GetMapping(value = "/getCurrentTime", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CurrentTimeResponseObject> getCurrentTime() {
		return ResponseEntity.status(HttpStatus.OK).body(currentTimeService.getCurrentTime());
	}

}
