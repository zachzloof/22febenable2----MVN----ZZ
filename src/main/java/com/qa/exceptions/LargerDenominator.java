package com.qa.exceptions;

public class LargerDenominator extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2181370462545999226L;

	public LargerDenominator() {
		super("You cant divide with a larger denominator");
	}
}
