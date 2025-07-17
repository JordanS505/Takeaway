package org.elis.model;

import com.google.gson.annotations.SerializedName;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class ElementoOrdine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable=false)
	String nome;
	@Column(nullable=false)
	Double prezzo;
	@Column(nullable=false)
	@SerializedName("quantity")
	int quantita;
	@ManyToOne
	private Portata portata;
	
	public ElementoOrdine() {
	}

	public ElementoOrdine(String nome, Double prezzo, int quantita) {
		this.nome = nome;
		this.prezzo = prezzo;
		this.quantita = quantita;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Portata getPortata() {
		return portata;
	}

	public void setPortata(Portata portata) {
		this.portata = portata;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	@Override
	public String toString() {
		return "ElementoOrdine [nome=" + nome + ", prezzo=" + prezzo + ", quantita=" + quantita + "]";
	}
	
	
}
