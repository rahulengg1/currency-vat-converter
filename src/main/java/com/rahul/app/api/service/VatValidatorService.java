package com.rahul.app.api.service;

import com.rahul.app.api.request.VatValidatorRequestObject;
import com.rahul.app.api.response.VatValidatorResponse;

/**
 * @author Rahul
 *
 */
public interface VatValidatorService {

	
	VatValidatorResponse getCountryCode(VatValidatorRequestObject vatCode)throws Exception;
}
