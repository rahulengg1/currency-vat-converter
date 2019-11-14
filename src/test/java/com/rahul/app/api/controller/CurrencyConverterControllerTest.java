package com.rahul.app.api.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.rahul.app.api.request.CurrencyRequestObject;
import com.rahul.app.api.response.CurrencyResponseObject;
import com.rahul.app.api.service.impl.CurrencyConverterServiceImpl;


class CurrencyConverterControllerTest {
	
	@InjectMocks
	private CurrencyConverterController currencyConverterController;
	
	@Mock
	private CurrencyConverterServiceImpl currencyConverterService;
	

	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		CurrencyResponseObject currencyResponseObject= new CurrencyResponseObject();
		currencyResponseObject.setAmount(10.00);
		when(currencyConverterService.convertCurrency(new CurrencyRequestObject())).thenReturn(currencyResponseObject);
	}
	
	
	
	@Test
	void testConvertCurrency()throws Exception {
		CurrencyRequestObject currencyRequestObject= new CurrencyRequestObject();
		CurrencyResponseObject currencyResponseObject= new CurrencyResponseObject();
		currencyResponseObject.setAmount(10.00);
		assertEquals(currencyResponseObject,currencyConverterController.convertCurrency(currencyRequestObject).getBody());
	}
	
	
	
	

}
