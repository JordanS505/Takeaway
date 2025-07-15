package org.elis.model;

public class Categoria {
	private String nome;
	private Long id;
	private Long id_Ristorante;
	
	
	
	public Categoria(Long id, String nome, Long id_Ristorante) {
		this.nome = nome;
		this.id = id;
		this.id_Ristorante = id_Ristorante;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId_Ristorante() {
		return id_Ristorante;
	}
	
	public void setId_Ristorante(Long id_Ristorante) {
		this.id_Ristorante = id_Ristorante;
	}
	
}