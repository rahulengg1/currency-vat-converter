package com.rahul.app.api.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.app.api.request.CurrencyRequestObject;
import com.rahul.app.api.response.CurrencyResponseObject;
import com.rahul.app.api.service.CurrencyConverterService;

import io.swagger.annotations.Api;

/**
 * @author Rahul
 *
 */

@Api(tags = "Currency Converter")
@RestController
@RequestMapping("/api")
public class CurrencyConverterController {

	private CurrencyConverterService currencyConverterService;

	public CurrencyConverterController(CurrencyConverterService currencyConverterService) {
		this.currencyConverterService = currencyConverterService;
	}

	@PostMapping(value = "/currency/convert", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CurrencyResponseObject> convertCurrency(@Valid @RequestBody CurrencyRequestObject body)throws Exception {

		return ResponseEntity.status(HttpStatus.OK).body(currencyConverterService.convertCurrency(body));

	}

}
