/*=============================================================================================================
OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
OOOOOOOooooooooooooooOOOOOOOOOOOOOOOOO8Coc::::ccoOOOOCoooooooooooooOOOOoooooooooooooo8OOOOOOO8Cocc:::ccoC8OOOOO
OOOOOOOooooooooooooooOOOOOOOOOOOOOOOOc:::::::::::COOOo:::::::::::::COOO:::::::::::::c8OOOOOc:::::::::::::OOOOOO
OOOCCCCOOOOOOOOOOooooOOOOOOOOOOOOOOO:::::cO888OCoOOOOo::::COOOOOOOO8OOO::::cOOOOOOOOO8OO8c:::::coO8888Ooc8OOOOO
OOOCCCCOOOOO8ccccOOOOooooooOOOOOOOOo::::oOOOOOOOOOOOOo::::COOOOOOOOOOOO::::cOOOOOOOOOOO8c::::c8OOOOOOOOOOOOOOOO
OOOCCCCOOOOO8ccccOOOOooooooOOOOOOOOC:::::COOOOOOOOOOOo::::COOOOOOOOOOOO::::cOOOOOOOOOOOo::::oOOOOOOOOOOOOOOOOOO
OOOCCCCOOccccOOOOccccOOooooOOOOOOOO8c:::::::cCOOOOOOOo::::::::::::oOOOO::::::::::::cOOO:::::OOOOOOOOOOOOOOOOOOO
OOOCCCCOOccccOOOOccccOOooooOOOOOOOOOOOo:::::::::cOOOOo::::::::::::oOOOO:::::::::::::OOO::::c8OOOOOOOOOOOOOOOOOO
OOOCCCCCCOOOOccccOOOOOOooooOOOOOOOOOOOOOOOoc::::::COOo::::C88888888OOOO::::c88888888OOO:::::OOOOOOOOOOOOOOOOOOO
OOOCCCCCCOOOOccccOOOOOOooooOOOOOOOOOOOOOOOOOOo::::c8Oo::::COOOOOOOOOOOO::::cOOOOOOOOOOOo::::c8OOOOOOOOOOOOOOOOO
OOOOOOOOOCCCCOOOOOOOOOOooooOOOOOOOOOOOOOOOOOOC::::c8Oo::::COOOOOOOOOOOO::::cOOOOOOOOOOO8::::::COOOOOOOOOOOOOOOO
OOOOOOOOOCCCCCCCCCCCCCCOOOOOOOOOOOO8c:coCCCo::::::OOOo::::cccccccccCOOO:::::cccccccco8OO8o:::::::oCCCCoc:OOOOOO
OOOOOOOOOCCCCCCCCCCCCCCOOOOOOOOOOOOO::::::::::::o8OOOo:::::::::::::COOO:::::::::::::c8OOOO8C:::::::::::::OOCCCC
OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO8OCCooooCO8OOOOOOOOOOOOOOOOOOOO8OO8OOOOOOOOOOOOOO8OOOOOOOO8OCCoooCCO88O88OO
OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
===============================================================================================================
 (C) 2007 - SEEC, Inc., Pittsburgh, PA
=============================================================================================================*/
package com.intellect.jobportal.exception;

import com.intellect.jobportal.enums.ErrorMessages;

/**
 * @author avinash.m
 *
 */
public class BaseException extends RuntimeException{
	
	private static final long serialVersionUID = 8642870094668737414L;
	

	
	public String[] customMessage;
	
	public String status;
	
	public ErrorMessages errorMessages;
	
	public BaseException() {
		super();
	}

	public BaseException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public BaseException(ErrorMessages errorMessages ) {
		super();
		this.errorMessages = errorMessages;
	}
	
	/**
	 * @param customErrorCode
	 * @param statusCode
	 */
	public BaseException(ErrorMessages errorMessages, String status) {
		super();
		this.errorMessages = errorMessages;
		this.status = status;
	}

	/**
	 * @param customErrorCode
	 * @param customMessage
	 * @param statusCode
	 */
	public BaseException(ErrorMessages errorMessages, String status, String... customMessage) {
		super();
		this.errorMessages = errorMessages;
		this.customMessage = customMessage;
		this.status = status;
	}


	
}
