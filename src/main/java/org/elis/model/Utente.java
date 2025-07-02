package org.elis.model;

public class Utente {
	private String username;
	
	private String password;
	
	private String nome;
	
	private String cognome;
	
	private String email;
	
	private Ruolo ruolo;
	

	public Utente(String username, String password, String nome, String cognome, String email, Ruolo ruolo) {
		this.username = username;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
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

	public Ruolo getRuolo() {
		return ruolo;
	}

	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}
	
	
	
}
