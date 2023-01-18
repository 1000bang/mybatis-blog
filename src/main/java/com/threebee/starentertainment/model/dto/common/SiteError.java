package com.threebee.starentertainment.model.dto.common;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SiteError {

	private String field;
	private String message;
	private String invalidValue;
	
}
