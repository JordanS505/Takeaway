package org.elis.model;

import java.time.LocalDate;

public class Utente {
	private String username;
	
	private String password;
	
	private String nome;
	
	private String cognome;
	
	private String email;
	
	private LocalDate dataDiNascita;
	
	private Long idRistorante;
	
	private Ruolo ruolo;
	

	public Utente(String username, String password, String nome, String cognome, String email,LocalDate dataDiNascita ,Ruolo ruolo) {
		this.username = username;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.dataDiNascita = dataDiNascita;
		this.idRistorante = null;
		this.ruolo = ruolo;
	}
	
	

	public Utente(String username, String password, String nome, String cognome, String email, LocalDate dataDiNascita,
			Long idRistorante, Ruolo ruolo) {
		this.username = username;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.dataDiNascita = dataDiNascita;
		this.idRistorante = idRistorante;
		this.ruolo = ruolo;
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
	
	
	
}
