package org.lab.insurance.common.exception;

@SuppressWarnings("serial")
public class InsuranceCommonException extends RuntimeException {

	public InsuranceCommonException(String message, Throwable cause) {
		super(message, cause);
	}

	public InsuranceCommonException(String message) {
		super(message);
	}

	public InsuranceCommonException(Throwable cause) {
		super(cause);
	}

}
