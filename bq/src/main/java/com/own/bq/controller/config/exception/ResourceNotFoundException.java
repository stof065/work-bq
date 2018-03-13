package com.own.bq.controller.config.exception;

import com.own.bq.controller.config.exception.abstrct.TechnicalException;

public class ResourceNotFoundException extends TechnicalException{

	public ResourceNotFoundException(String msg) {
		super(msg);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -8089667459456040667L;

}
