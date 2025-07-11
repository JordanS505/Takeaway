package org.elis.model;

import com.google.gson.annotations.SerializedName;

public class ElementoOrdine {
	String nome;
	
	Double prezzo;
	@SerializedName("quantity")
	int quantita;

	public ElementoOrdine(String nome, Double prezzo, int quantita) {
		this.nome = nome;
		this.prezzo = prezzo;
		this.quantita = quantita;
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
	
}
