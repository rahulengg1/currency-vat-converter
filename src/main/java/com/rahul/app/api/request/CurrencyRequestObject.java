package com.rahul.app.api.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Rahul
 *
 */
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class CurrencyRequestObject {

	@NotNull(message = "Amount cannot be blank")
	private Double amount;

	@NotNull(message = "Source Currency cannot be blank")
	@NotEmpty(message = "Source Currency cannot be empty")
	private String sourceCurrency;

	@NotNull(message = "Target Currency cannot be blank")
	@NotEmpty(message = "Target Currency cannot be empty")
	private String targetCurrency;
}
