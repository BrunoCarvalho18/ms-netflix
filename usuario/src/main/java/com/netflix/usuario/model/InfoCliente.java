package com.netflix.usuario.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "usuarios")
public class InfoCliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cpf;
	private String nome;
	private String estado;
	private String endereco;

	public InfoCliente(InfoCliente infoCliente) {
		this.cpf = infoCliente.getCpf();
		this.nome = infoCliente.getNome();
		this.estado = infoCliente.getEstado();
		this.endereco = infoCliente.getEndereco();
	}

	public InfoCliente() {

	}

	public InfoCliente(String cpf,String nome, String estado, String endereco) {
		this.nome = nome;
		this.estado = estado;
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

}
