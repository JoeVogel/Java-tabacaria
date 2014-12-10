package br.com.tabacaria.model;

public class CategoriaNaoEncontradaException extends RuntimeException{

	public CategoriaNaoEncontradaException() {

	}

	public CategoriaNaoEncontradaException(String message) {
		super(message);

	}

	public CategoriaNaoEncontradaException(Throwable cause) {
		super(cause);

	}

	public CategoriaNaoEncontradaException(String message, Throwable cause) {
		super(message, cause);

	}

	public CategoriaNaoEncontradaException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}
}
