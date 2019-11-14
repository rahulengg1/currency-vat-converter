package com.rahul.app.api.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Rahul
 *
 */
@Getter
@Setter
@Configuration
@NoArgsConstructor
public class AppConfig {

	@Value("${apilayer.access_key}")
	private String currencyLayerAccessKey;
	
	@Value("${apilayer.base_url}")
	private String currencyLayerBaseUrl;
	
	@Value("${apilayer.end_point}")
	private String currencyLayerEndPoint;
	
	
	@Value("${cloudmersive.client.api_key}")
	private String cloudmersiveApiKey;
}
