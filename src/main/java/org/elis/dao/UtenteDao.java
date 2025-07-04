package org.elis.dao;

import java.util.List;

import org.elis.model.Utente;

public interface UtenteDao extends GeneralDao<Utente> {
	public boolean login(String email,String password) throws Exception;
	
	public Utente findUtenteByUsername(String username) throws Exception;
	
	public Utente findUtenteByEmail(String Email) throws Exception;
	
	public List<Utente> findUtentiByNome(String nome) throws Exception;
	
	public List<Utente> findUtentiByCognome(String cognome) throws Exception;
	
	public List<Utente> findRistoratori() throws Exception;
	
	public Utente findRistoranteByIndirizzo(String indirizzo) throws Exception;
	
	public List<Utente> findRistoranteByNome(String ristorante) throws Exception;
	
	public void updatePasswordByEmail(String email,String password) throws Exception;
}
