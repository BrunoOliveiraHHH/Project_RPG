package br.com.euphoriarpg.model.exceptions;

public class AplicacaoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AplicacaoException() {
	}

	public AplicacaoException(String message) {
		super(message);
	}

	public AplicacaoException(ExceptionValidacoes message) {
		super(message.getMessage());
	}

}
