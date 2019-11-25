package edu.fiap.tcd.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;


@Entity(name = "usuarios")
public class Filme {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String genero;
	private List<String> atores =new ArrayList<String>();
	private String descricao;
	private String detalhes;
	private List<String> listaDePalavras;
	
	public Filme() {
		
	}
	
	public Filme( String nome, String genero) {

		this.nome = nome;
		this.genero=genero;
	}

	public void setId(Long id) {
		this.id=id;
	}
	
	public Long getId() {
		return this.id;
	}

	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public List<String> getAtores() {
		return atores;
	}
	public void setAtores(List<String> atores) {
		this.atores = atores;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getDetalhes() {
		return detalhes;
	}
	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}
	public List<String> getListaDePalavras() {
		return listaDePalavras;
	}
	public void setListaDePalavras(List<String> listaDePalavras) {
		this.listaDePalavras = listaDePalavras;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		Filme other = (Filme) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	
	
	
	
	

}
