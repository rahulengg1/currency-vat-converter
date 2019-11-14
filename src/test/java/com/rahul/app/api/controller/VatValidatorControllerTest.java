package com.rahul.app.api.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.rahul.app.api.request.VatValidatorRequestObject;
import com.rahul.app.api.response.VatValidatorResponse;
import com.rahul.app.api.service.impl.VatValidatorServiceImpl;

class VatValidatorControllerTest {

	
	@InjectMocks
	private VatValidatorController vatValidatorController;
	
	@Mock
	private VatValidatorServiceImpl vatValidatorServiceImpl;
	
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		VatValidatorResponse currencyResponseObject= new VatValidatorResponse();
		currencyResponseObject.setCountryCode("DE");
		when(vatValidatorServiceImpl.getCountryCode(new VatValidatorRequestObject())).thenReturn(currencyResponseObject);
	}
	
	
	
	
	@Test
	void testValidateVat()throws Exception{
		VatValidatorRequestObject requestObject=new VatValidatorRequestObject();
		VatValidatorResponse currencyResponseObject= new VatValidatorResponse();
		currencyResponseObject.setCountryCode("DE");
		assertEquals(currencyResponseObject, vatValidatorController.validateVat(requestObject).getBody());
	}

}
