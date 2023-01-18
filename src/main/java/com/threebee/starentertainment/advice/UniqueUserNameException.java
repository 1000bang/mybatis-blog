package com.threebee.starentertainment.advice;

import org.springframework.dao.DuplicateKeyException;

public class UniqueUserNameException extends DuplicateKeyException {

	private static final long serialVersionUID = 1L;
	private String defaultMessage;
	private String field;
	private String invalidValue;
	
	public UniqueUserNameException(String msg) {
		super(msg);
		defaultMessage = msg;
	}

	public UniqueUserNameException(String msg, String field, String invalidValue) {
		super(msg);
		this.defaultMessage = msg;
		this.field = field;
		this.invalidValue = invalidValue;
		
	}

	public String getField() {
		return field;
	}

	public String getInvalidValue() {
		return invalidValue;
	}

	public String getDefaultMessage() {
		return defaultMessage;
	}

	
	
	

}
