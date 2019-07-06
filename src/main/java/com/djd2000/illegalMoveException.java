package com.djd2000;

public class illegalMoveException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public illegalMoveException(String errorMessage) {
		super(errorMessage);
	}
}
