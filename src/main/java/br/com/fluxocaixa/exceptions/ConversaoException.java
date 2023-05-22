package br.com.fluxocaixa.exceptions;

public class ConversaoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ConversaoException(String message, Throwable cause) {
		super(message, cause); 
	}
}
