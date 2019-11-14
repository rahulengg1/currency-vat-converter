package com.rahul.currency.vat.converter.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.rahul.app.api.configuration.AppConfig;
import com.rahul.app.api.request.CurrencyRequestObject;
import com.rahul.app.api.request.VatValidatorRequestObject;

public class AllSharedObjectTest {

	@Test
	public void TestCurrencyRequestObject() {

		CurrencyRequestObject object = new CurrencyRequestObject();
		object.setAmount(10.00);
		object.setSourceCurrency("EUR");
		object.setTargetCurrency("GBP");
		assertEquals(10.00, object.getAmount());
		assertEquals("EUR", object.getSourceCurrency());
		assertEquals("GBP", object.getTargetCurrency());
	}

	@Test
	public void TestVatValidatorRequestObject() {

		VatValidatorRequestObject object = new VatValidatorRequestObject();

		object.setVatNo("GBP00011100");
		assertEquals("GBP00011100", object.getVatNo());

	}

	@Test
	public void TestAppConfig() {
		AppConfig object = new AppConfig();
		object.setCloudmersiveApiKey("X2ssd2dsdsaas1122");
		object.setCurrencyLayerAccessKey("Oe3ddawe9");
		object.setCurrencyLayerBaseUrl("http://test.com");
		object.setCurrencyLayerEndPoint("test");
		assertEquals("X2ssd2dsdsaas1122", object.getCloudmersiveApiKey());
		assertEquals("Oe3ddawe9", object.getCurrencyLayerAccessKey());
		assertEquals("http://test.com", object.getCurrencyLayerBaseUrl());
		assertEquals("test", object.getCurrencyLayerEndPoint());

	}

	
}
