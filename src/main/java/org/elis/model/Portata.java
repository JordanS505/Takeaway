package org.elis.model;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
@Entity
public class Portata {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String nome;
	
	private Blob foto;
	
	@Column(nullable = false)
	private String descrizione;
	@Column(nullable = false)
	private Double prezzo;
	@ManyToOne
	private Categoria categoria;
	
	@OneToMany(mappedBy = "portata")
	private List<ElementoOrdine> elementiOrdine;
	
	public Portata() {
	}

	
	
	public Portata(Long id, String nome, Blob foto, String descrizione, Double prezzo, Categoria categoria) {
		this.id=id;
		this.nome = nome;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.categoria=categoria;
	}
	
	public Portata(String nome){
		this.nome=nome;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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
