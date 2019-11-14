package com.rahul.app.api.service.impl;

import org.springframework.stereotype.Service;

import com.cloudmersive.client.VatApi;
import com.cloudmersive.client.invoker.ApiClient;
import com.cloudmersive.client.invoker.Configuration;
import com.cloudmersive.client.invoker.auth.ApiKeyAuth;
import com.cloudmersive.client.model.VatLookupRequest;
import com.cloudmersive.client.model.VatLookupResponse;
import com.rahul.app.api.configuration.AppConfig;
import com.rahul.app.api.request.VatValidatorRequestObject;
import com.rahul.app.api.response.VatValidatorResponse;
import com.rahul.app.api.service.VatValidatorService;

/**
 * @author Rahul
 *
 */
@Service
public class VatValidatorServiceImpl implements VatValidatorService {

	private AppConfig appConfig;

	public VatValidatorServiceImpl(AppConfig appConfig) {
		this.appConfig = appConfig;
	}

	@Override
	public VatValidatorResponse getCountryCode(VatValidatorRequestObject vatCode) throws Exception {

		VatValidatorResponse response = new VatValidatorResponse();

		ApiClient defaultClient = Configuration.getDefaultApiClient();

		ApiKeyAuth Apikey = (ApiKeyAuth) defaultClient.getAuthentication("Apikey");
		Apikey.setApiKey(appConfig.getCloudmersiveApiKey());

		VatApi apiInstance = new VatApi();
		VatLookupRequest input = new VatLookupRequest();
		input.setVatCode(vatCode.getVatNo());

		VatLookupResponse result = apiInstance.vatVatLookup(input);
		response.setCountryCode(result.getCountryCode());

		return response;
	}

}
