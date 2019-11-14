package com.rahul.app.api.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.rahul.app.api.response.CurrentTimeResponseObject;
import com.rahul.app.api.service.CurrentTimeService;

class CurrentTimeControllerTest {

	

	@InjectMocks
	private CurrentTimeController currentTimeController;
	
	@Mock
	private CurrentTimeService currentTimeService;
	
	private final LocalTime timeObject= LocalTime.now();
	
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		CurrentTimeResponseObject currentTimeResponseObject= new CurrentTimeResponseObject();
		currentTimeResponseObject.setCurrentTime(timeObject);
		
		when(currentTimeService.getCurrentTime()).thenReturn(currentTimeResponseObject);
	}
	
	
	@Test
	void testGetCurrentTime() {
		CurrentTimeResponseObject currentTimeResponseObject= new CurrentTimeResponseObject();
		currentTimeResponseObject.setCurrentTime(timeObject);
		
		assertEquals(currentTimeResponseObject, currentTimeController.getCurrentTime().getBody());
	}

}
