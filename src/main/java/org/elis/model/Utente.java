package org.elis.model;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.time.LocalDate;

import java.util.Base64;
import java.util.List;

import org.elis.enumerazioni.Ruolo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
@Entity
public class Utente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUtente;
	@Column(nullable=false , unique=true)
	private String username;
	@Column(nullable=false)
	private String password;
	@Column(nullable=false)
	private String nome;
	@Column(nullable=false)
	private String cognome;
	@Column(nullable=false, unique=true)
	private String email;
	@Column(nullable=false)
	private LocalDate dataDiNascita;
	
	private String nomeRistorante;
	
	@ManyToMany
	@JoinTable(
		    name = "Utente_Tipologia",
		    joinColumns = @JoinColumn(name="idUtente"),
		    inverseJoinColumns = @JoinColumn(name="id")
		)
	private List<Tipologia> tipologie;
	
	@Column(unique=true)
	private String indirizzoRistorante;
	
	private Blob foto;
	
	private Double votoM;
	@Column(nullable=false)
	private Ruolo ruolo;
	
	@OneToMany(mappedBy = "ristorante")
	private List<Categoria> categorie;
	
	@OneToMany(mappedBy = "cliente")
	private List<Ordine> ordini;
	
	@OneToMany(mappedBy = "ristoratore")
	private List<Ordine> ordiniRist;
	
	public Utente() {
	}

	public Utente(Long idUtente, String username, String password, String nome, String cognome, String email,LocalDate dataDiNascita ,Ruolo ruolo) {
		this.idUtente=idUtente;
		this.username = username;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.dataDiNascita = dataDiNascita;
		this.ruolo = ruolo;
	}

	
	
	public Utente(Long idUtente, String username, String password, String nome, String cognome, String email, LocalDate dataDiNascita,
			String nomeRistorante, String indirizzoRistorante, Blob foto, Ruolo ruolo) {
	    this.idUtente = idUtente;
		this.username = username;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.dataDiNascita = dataDiNascita;
		this.nomeRistorante = nomeRistorante;
		this.indirizzoRistorante = indirizzoRistorante;
		this.foto = foto;
		this.ruolo = ruolo;
	}



	public Utente(Long idUtente, String username, String password, String nome, String cognome, String email,
			LocalDate dataNascita, String nomeRistorante, String indirizzoRistorante, List<Tipologia> tipologie, List<Ordine> ordiniRist, Blob foto, Double votoM) {
	    this.idUtente = idUtente;
		this.username = username;
	    this.password = password;
	    this.nome = nome;
	    this.cognome = cognome;
	    this.email = email;
	    this.dataDiNascita = dataNascita;
	    this.nomeRistorante = nomeRistorante;
	    this.indirizzoRistorante = indirizzoRistorante;
	    this.tipologie=tipologie;
	    this.foto = foto;
	    this.votoM = votoM;
	    this.ruolo = Ruolo.RISTORATORE;
	    this.ordiniRist=ordiniRist;
	}



	public Utente(Long idUtente, String nomeRistorante) {
	    this.idUtente = idUtente;
		this.nomeRistorante=nomeRistorante;
	}



	public Utente(Long idUtente, String nome, String cognome) {
		this.idUtente=idUtente;
		this.nome=nome;
		this.cognome=cognome;
	}

	public List<Categoria> getCategorie() {
		return categorie;
	}

	public void setCategorie(List<Categoria> categorie) {
		this.categorie = categorie;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public LocalDate getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(LocalDate dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public Ruolo getRuolo() {
		return ruolo;
	}

	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}

	public String getNomeRistorante() {
		return nomeRistorante;
	}

	public void setNomeRistorante(String nomeRistorante) {
		this.nomeRistorante = nomeRistorante;
	}

	public String getIndirizzoRistorante() {
		return indirizzoRistorante;
	}

	public void setIndirizzoRistorante(String indirizzoRistorante) {
		this.indirizzoRistorante = indirizzoRistorante;
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
	
	public Double getVotoM() {
		return votoM;
	}

	public void setVotoM(Double votoM) {
		this.votoM = votoM;
	}
	

	public List<Tipologia> getTipologie() {
	    return tipologie;
	}
	
	public void setTipologie(List<Tipologia> tipologie) {
	    this.tipologie = tipologie;
	}

	public long getIdUtente() {
		return idUtente;
	}



	@Override
	public String toString() {
		return "Utente [idUtente=" + idUtente + ", username=" + username + ", password=" + password + ", nome=" + nome
				+ ", cognome=" + cognome + ", email=" + email + ", dataDiNascita=" + dataDiNascita + ", nomeRistorante="
				+ nomeRistorante + ", tipologie=" + tipologie + ", indirizzoRistorante=" + indirizzoRistorante
				+ ", votoM=" + votoM + ", ruolo=" + ruolo + "]";
	}



	public void setIdUtente(Long idUtente) {
		this.idUtente = idUtente;
	}

	public List<Ordine> getOrdini() {
		return ordini;
	}

	public void setOrdini(List<Ordine> ordini) {
		this.ordini = ordini;
	}

	public List<Ordine> getOrdiniRist() {
		return ordiniRist;
	}

	public void setOrdiniRist(List<Ordine> ordiniRist) {
		this.ordiniRist = ordiniRist;
	}
	
	
	
}
