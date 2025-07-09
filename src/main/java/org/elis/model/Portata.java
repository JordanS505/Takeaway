package org.elis.model;

public class Portata {
	private String nome;
	
	private byte[] foto;
	
	private String descrizione;
	
	private Double prezzo;
	
	private Long IdCategoria;
	
	
	
	public Portata(String nome, byte[] foto, String descrizione, Double prezzo) {
		this.nome = nome;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
	}

	
	
	public Portata(String nome, byte[] foto, String descrizione, Double prezzo, Long idCategoria) {
		this.nome = nome;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		IdCategoria = idCategoria;
	}



	public Long getIdCategoria() {
		return IdCategoria;
	}



	public void setIdCategoria(Long idCategoria) {
		IdCategoria = idCategoria;
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

}
