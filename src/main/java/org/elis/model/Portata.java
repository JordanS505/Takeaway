package org.elis.model;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;

public class Portata {
	private Long id;
	
	private String nome;
	
	private Blob foto;
	
	private String descrizione;
	
	private Double prezzo;
	
	private Long IdCategoria;
	
	public Portata(Long id, String nome, Blob foto, String descrizione, Double prezzo, Long idCategoria) {
		this.id = id;
		this.nome = nome;
		this.foto = foto;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		IdCategoria = idCategoria;
	}

	public Portata(String nome, Blob foto, String descrizione, Double prezzo) {
		this.nome = nome;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
	}
	
	public Portata(String nome){
		this.nome=nome;
	}

	public Portata(String nome, Blob foto, String descrizione, Double prezzo, Long idCategoria) {
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

	public Blob getFoto() {
		return foto;
	}
	
	public String getBase64ImageString() {
		byte[] bytes = null;
		try {
			bytes = foto.getBinaryStream().readAllBytes();
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Base64.getEncoder().encodeToString(bytes);
	}
	
	public void setFoto(Blob foto) {
		this.foto = foto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	
}
