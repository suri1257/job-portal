package com.intellect.jobportal.enums;

public enum ErrorMessages {

	DATA_NOT_FOUND("5000", "Data not found ");

	private String errorCode;
	private String errorMessage;
	
	private ErrorMessages( String errorCode, String errorMessage ) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
	public String geterrorCode( ) {
		return this.errorCode ;
	}
	public String geterrorMessage( ) {
		return this.errorMessage ;
	}
}
