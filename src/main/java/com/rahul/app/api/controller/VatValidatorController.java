package com.rahul.app.api.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.app.api.request.VatValidatorRequestObject;
import com.rahul.app.api.response.VatValidatorResponse;
import com.rahul.app.api.service.VatValidatorService;

import io.swagger.annotations.Api;

/**
 * @author Rahul
 *
 */
@Api(tags = "Vat Validator")
@RestController
@RequestMapping("/api")
public class VatValidatorController {
	
	
	private VatValidatorService validatorService;

	public VatValidatorController(VatValidatorService validatorService) {
		super();
		this.validatorService = validatorService;
	}
	
	@PostMapping(value = "/vat/validate", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<VatValidatorResponse> validateVat(@Valid @RequestBody VatValidatorRequestObject body)throws Exception {

		return ResponseEntity.status(HttpStatus.OK).body(validatorService.getCountryCode(body));

	}
}
