package org.elis.model;

import java.time.LocalDate;
import java.util.List;

import org.elis.enumerazioni.Ruolo;

public class Utente {
	private String username;
	
	private String password;
	
	private String nome;
	
	private String cognome;
	
	private String email;
	
	private LocalDate dataDiNascita;
	
	private String nomeRistorante;
	
	private List<Tipologia> tipologie;
	
	private String indirizzoRistorante;

	private byte[] foto;
	
	private Double votoM;
	
	private Ruolo ruolo;
	

	public Utente(String username, String password, String nome, String cognome, String email,LocalDate dataDiNascita ,Ruolo ruolo) {
		this.username = username;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.dataDiNascita = dataDiNascita;
		this.ruolo = ruolo;
	}

	
	
	public Utente(String username, String password, String nome, String cognome, String email, LocalDate dataDiNascita,
			String nomeRistorante, String indirizzoRistorante, byte[] foto, Ruolo ruolo) {
		super();
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



	public Utente(String username, String password, String nome, String cognome, String email,
			LocalDate dataNascita, String nomeRistorante, String indirizzoRistorante, List<Tipologia> tipologie, byte[] foto, Double votoM, Ruolo ruolo) {
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
	    this.ruolo = Ruolo.ristoratore;

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

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
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
	
}
