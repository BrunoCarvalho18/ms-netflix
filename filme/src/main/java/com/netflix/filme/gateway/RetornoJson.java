package com.netflix.filme.gateway;

public class RetornoJson {
	
	private String mensagem;

	public RetornoJson() {
	}
	
	public RetornoJson(String message) {
		mensagem = message;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
