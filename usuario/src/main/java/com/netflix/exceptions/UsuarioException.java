package com.netflix.exceptions;

public class UsuarioException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UsuarioException(String mensagem) {
		super(mensagem);
	}

}
