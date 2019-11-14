package com.rahul.app.api.service.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;

import com.rahul.app.api.response.CurrentTimeResponseObject;

class CurrentTimeServiceImplTest {

	

	private CurrentTimeServiceImpl currentTimeServiceImpl;
	
	@Test
	void testGetCurrentTime() {
		currentTimeServiceImpl = new CurrentTimeServiceImpl();
		assertTrue(currentTimeServiceImpl.getCurrentTime() instanceof CurrentTimeResponseObject);
		assertTrue(currentTimeServiceImpl.getCurrentTime().getCurrentTime() instanceof LocalTime);
	}
	
	

}
