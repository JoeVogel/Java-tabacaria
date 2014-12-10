package br.com.tabacaria.model;

public class CategoriaJaExisteException extends RuntimeException{

	public CategoriaJaExisteException() {
	}

	public CategoriaJaExisteException(String message) {
		super(message);
	}

	public CategoriaJaExisteException(Throwable cause) {
		super(cause);
	}

	public CategoriaJaExisteException(String message, Throwable cause) {
		super(message, cause);
	}

	public CategoriaJaExisteException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
