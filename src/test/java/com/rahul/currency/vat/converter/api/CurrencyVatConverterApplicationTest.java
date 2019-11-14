package com.rahul.currency.vat.converter.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rahul.app.api.configuration.AppConfig;
import com.rahul.app.api.controller.CurrencyConverterController;
import com.rahul.app.api.controller.CurrentTimeController;
import com.rahul.app.api.controller.VatValidatorController;
import com.rahul.app.api.request.CurrencyRequestObject;
import com.rahul.app.api.request.VatValidatorRequestObject;
import com.rahul.app.api.service.impl.CurrencyConverterServiceImpl;
import com.rahul.app.api.service.impl.CurrentTimeServiceImpl;
import com.rahul.app.api.service.impl.VatValidatorServiceImpl;



@AutoConfigureMockMvc
@ContextConfiguration(classes = { CurrencyConverterController.class, CurrencyConverterServiceImpl.class
		, VatValidatorController.class, VatValidatorServiceImpl.class,AppConfig.class, CurrentTimeController.class,
		CurrentTimeServiceImpl.class})
@WebMvcTest
class CurrencyVatConverterApplicationTest {

	
	
	@Autowired
	private MockMvc mockMvc;

	
	
	private static final String CURRENCY_CONVERTER_API_ENDPOINT = "/api/currency/convert";
	
	
	private static final String VAT_VALIDATE_API_ENDPOINT = "/api/vat/validate";

	@Autowired
	private ObjectMapper objectMapper;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {

	}
	
	
	
	@Test
	void whenCurrencyConv_ValidInput_thenReturns200() throws Exception {
		CurrencyRequestObject model = new CurrencyRequestObject();
		model.setAmount(10.00);
		model.setSourceCurrency("EUR");
		model.setTargetCurrency("INR");

		mockMvc.perform(post(CURRENCY_CONVERTER_API_ENDPOINT).contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_JSON_VALUE).content(objectMapper.writeValueAsString(model)))
				.andExpect(status().isOk());
	}
	
	
	@Test
	void whenCurrencyConv_InValidAmount_thenReturns400() throws Exception {
		CurrencyRequestObject model = new CurrencyRequestObject();
		model.setSourceCurrency("EUR");
		model.setTargetCurrency("INR");

		mockMvc.perform(post(CURRENCY_CONVERTER_API_ENDPOINT).contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_JSON_VALUE).content(objectMapper.writeValueAsString(model)))
				.andExpect(status().isBadRequest());
	}
	
	
	@Test
	void whenCurrencyConv_InValidSourceCCY_thenReturns400() throws Exception {
		CurrencyRequestObject model = new CurrencyRequestObject();
		model.setAmount(10.00);
		model.setTargetCurrency("INR");

		mockMvc.perform(post(CURRENCY_CONVERTER_API_ENDPOINT).contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_JSON_VALUE).content(objectMapper.writeValueAsString(model)))
				.andExpect(status().isBadRequest());
	}
	
	
	@Test
	void whenCurrencyConv_InValidTargetCCY_thenReturns400() throws Exception {
		CurrencyRequestObject model = new CurrencyRequestObject();
		model.setAmount(10.00);
		model.setSourceCurrency("EUR");
		
		mockMvc.perform(post(CURRENCY_CONVERTER_API_ENDPOINT).contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_JSON_VALUE).content(objectMapper.writeValueAsString(model)))
				.andExpect(status().isBadRequest());
	}
	
	
	@Test
	void whenVatValidate_ValidInput_thenReturns200() throws Exception {
		VatValidatorRequestObject model = new VatValidatorRequestObject();
		model.setVatNo("DE122222222");

		mockMvc.perform(post(VAT_VALIDATE_API_ENDPOINT).contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_JSON_VALUE).content(objectMapper.writeValueAsString(model)))
				.andExpect(status().isOk());
	}
	
	
	@Test
	void whenVatValidate_InValidInput_thenReturns400() throws Exception {
		VatValidatorRequestObject model = new VatValidatorRequestObject();
		
		mockMvc.perform(post(VAT_VALIDATE_API_ENDPOINT).contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_JSON_VALUE).content(objectMapper.writeValueAsString(model)))
				.andExpect(status().isBadRequest());
	}
	
	
	@Test
	public void applicationContextLoaded() {
	}

	
	
}
