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
public class VatValidatorRequestObject {

	@NotNull(message = "VAT No cannot be blank")
	@NotEmpty(message = "VAT No cannot be empty")
	private String vatNo;
}
