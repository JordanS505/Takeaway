package org.elis.model;

public class Ingrediente {
	String nome;
	
	boolean senzaLattosio;
	
	boolean senzaGlutine;

	public Ingrediente(String nome, boolean senzaLattosio, boolean senzaGlutine) {
		this.nome = nome;
		this.senzaLattosio = senzaLattosio;
		this.senzaGlutine = senzaGlutine;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isSenzaLattosio() {
		return senzaLattosio;
	}

	public void setSenzaLattosio(boolean senzaLattosio) {
		this.senzaLattosio = senzaLattosio;
	}

	public boolean isSenzaGlutine() {
		return senzaGlutine;
	}

	public void setSenzaGlutine(boolean senzaGlutine) {
		this.senzaGlutine = senzaGlutine;
	}
	
}
