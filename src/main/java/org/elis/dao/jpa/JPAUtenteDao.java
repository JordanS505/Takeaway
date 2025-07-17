package org.elis.dao.jpa;

import java.util.List;

import org.elis.dao.UtenteDao;
import org.elis.model.Utente;

import jakarta.persistence.EntityManagerFactory;

public class JPAUtenteDao implements UtenteDao{

	private EntityManagerFactory emf;
	
	public JPAUtenteDao(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public void insert(Utente entity) throws Exception {
		
		
	}

	@Override
	public Utente selectById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Utente> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Utente entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean login(String email, String password) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Utente findUtenteByUsername(String username) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Utente> findUtentiByNome(String nome) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Utente> findUtentiByCognome(String cognome) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Utente> findRistoratori() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utente findRistoranteByIndirizzo(String indirizzo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Utente> findRistoranteByNome(String ristorante) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatePasswordByEmail(String email, String password) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Utente> findRistoranteByTipologia(String ristoranteNome) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utente findUtenteByLogin(String email, String password) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object findUtenteByEmail(String email) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
