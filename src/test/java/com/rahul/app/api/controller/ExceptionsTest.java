package com.rahul.app.api.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rahul.app.api.exception.CustomException;
import com.rahul.app.api.request.CurrencyRequestObject;

@SpringBootTest
class ExceptionsTest {
	
	@Autowired
	private CurrencyConverterController currencyConverterController;
	
	
	
	@Test
	public void testExceptions()throws Exception {
		CurrencyRequestObject model = new CurrencyRequestObject();
		model.setAmount(10.00);
		model.setSourceCurrency("TEST");
		model.setTargetCurrency("INR");

		
		
		assertThrows(CustomException.class, () -> {
			currencyConverterController.convertCurrency(model);
		});
		
	}	
	

}
