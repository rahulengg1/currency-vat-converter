package com.rahul.app.api.service;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.rahul.app.api.request.CurrencyRequestObject;
import com.rahul.app.api.response.CurrencyResponseObject;

/**
 * @author Rahul
 *
 */
public interface CurrencyConverterService {
	
	CurrencyResponseObject convertCurrency(CurrencyRequestObject request)throws ClientProtocolException, IOException;
	

}
