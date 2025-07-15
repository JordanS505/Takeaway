package org.elis.model;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import org.elis.enumerazioni.Ruolo;

public class Utente {
	private Long idUtente;
	
	private String username;
	
	private String password;
	
	private String nome;
	
	private String cognome;
	
	private String email;
	
	private LocalDate dataDiNascita;
	
	private String nomeRistorante;
	
	private List<Tipologia> tipologie;
	
	private String indirizzoRistorante;

	private Blob foto;
	
	private Double votoM;
	
	private Ruolo ruolo;
	

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
			LocalDate dataNascita, String nomeRistorante, String indirizzoRistorante, List<Tipologia> tipologie, Blob foto, Double votoM) {
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
	
	
	
}
