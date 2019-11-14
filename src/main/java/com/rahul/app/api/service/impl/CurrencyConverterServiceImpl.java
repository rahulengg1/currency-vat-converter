package com.rahul.app.api.service.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.rahul.app.api.configuration.AppConfig;
import com.rahul.app.api.exception.CustomException;
import com.rahul.app.api.request.CurrencyRequestObject;
import com.rahul.app.api.response.CurrencyResponseObject;
import com.rahul.app.api.service.CurrencyConverterService;
import com.rahul.app.api.shared.AppConstants;

@Service
public class CurrencyConverterServiceImpl implements CurrencyConverterService {

	private AppConfig appConfig;

	public CurrencyConverterServiceImpl(AppConfig appConfig) {
		this.appConfig = appConfig;
	}

	@Override
	public CurrencyResponseObject convertCurrency(CurrencyRequestObject request)
			throws ClientProtocolException, IOException {

		CurrencyResponseObject currencyResponseObject = new CurrencyResponseObject();

		String ACCESS_KEY = appConfig.getCurrencyLayerAccessKey();
		String BASE_URL = appConfig.getCurrencyLayerBaseUrl();
		String ENDPOINT = appConfig.getCurrencyLayerEndPoint();
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet get = new HttpGet(BASE_URL + ENDPOINT + "?access_key=" + ACCESS_KEY + "&currencies="
				+ request.getSourceCurrency() + "," + request.getTargetCurrency());

		CloseableHttpResponse response = httpClient.execute(get);
		HttpEntity entity = response.getEntity();

		// if (entity != null && entity.getContentLength() > 0) {
		try {
			JSONObject exchangeRates = new JSONObject(EntityUtils.toString(entity));
			System.out.println("Live Currency Exchange Rates" + exchangeRates);

			Double denominator = exchangeRates.getJSONObject("quotes").getDouble("USD" + request.getSourceCurrency());
			Double numerator = exchangeRates.getJSONObject("quotes").getDouble("USD" + request.getTargetCurrency());

			BigDecimal bigDecimalValue = BigDecimal.valueOf(numerator / denominator);

			currencyResponseObject.setAmount(
					bigDecimalValue.setScale(AppConstants.DECIMALS_PLACE, BigDecimal.ROUND_HALF_UP).doubleValue());
			response.close();
		} catch (JSONException ex) {
			response.close();
			throw new CustomException("Exchange rate not found", "Exchange rate not found");
		}

		return currencyResponseObject;
	}

}
