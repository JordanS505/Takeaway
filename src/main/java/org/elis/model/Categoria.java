package org.elis.model;

public class Categoria {
	String nome;
	Long id;

	public Categoria(String nome) {
		this.nome = nome;
	}

	public Categoria(String nome, Long id) {
		this.nome = nome;
		this.id = id;
	}

	public Long getId() {
		return id;
	}



	public void setId(Long idRistorante) {
		this.id = idRistorante;
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}