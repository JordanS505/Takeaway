package org.elis.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "id_ristorante", nullable = false)
	private Utente ristorante;
	@OneToMany(mappedBy = "categoria")
	private List<Portata> portate;
	
	
	public Categoria() {
	}

	public Utente getRistorante() {
		return ristorante;
	}

	public void setRistorante(Utente ristorante) {
		this.ristorante = ristorante;
	}

	public List<Portata> getPortate() {
		return portate;
	}

	public void setPortate(List<Portata> portate) {
		this.portate = portate;
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
	

	
}