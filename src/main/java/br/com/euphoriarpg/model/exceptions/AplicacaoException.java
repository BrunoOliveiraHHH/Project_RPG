package br.com.euphoriarpg.model.exceptions;

public class AplicacaoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	// Parameterless Constructor
	public AplicacaoException() {}

	// Constructor that accepts a message
	public AplicacaoException(String message)
    {
       super(message);
    }

}
