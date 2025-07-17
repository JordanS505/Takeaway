package org.elis.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
@Entity
public class Tipologia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable=false)
	private String nome;
	@ManyToMany(mappedBy = "tipologie")
	private List<Utente> ristoranti; 
	
	public Tipologia() {
	}
	
	public Tipologia(String nome) {
		this.nome = nome;
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

	public List<Utente> getRistoranti() {
		return ristoranti;
	}

	public void setRistoranti(List<Utente> ristoranti) {
		this.ristoranti = ristoranti;
	}
	
}
