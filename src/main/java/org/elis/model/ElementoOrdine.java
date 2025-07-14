package org.elis.model;

import com.google.gson.annotations.SerializedName;

public class ElementoOrdine {
	String nome;
	
	Double prezzo;
	@SerializedName("quantity")
	int quantita;
	
	Long idPortata;

	public ElementoOrdine(String nome, Double prezzo, int quantita) {
		this.nome = nome;
		this.prezzo = prezzo;
		this.quantita = quantita;
	}
	
	public ElementoOrdine(String nome, Double prezzo, int quantita, Long idPortata) {
		this.nome = nome;
		this.prezzo = prezzo;
		this.quantita = quantita;
		this.idPortata = idPortata;
	}

	public Long getIdPortata() {
		return idPortata;
	}

	public void setIdPortata(Long idPortata) {
		this.idPortata = idPortata;
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
