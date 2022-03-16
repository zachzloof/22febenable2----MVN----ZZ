package com.qa.exceptions;

public class MultiplyByFiveException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -912855787120246330L;

	public MultiplyByFiveException () {
		super("You cant multiply by 5");
	}

}
