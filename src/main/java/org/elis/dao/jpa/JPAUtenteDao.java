package org.elis.dao.jpa;

import java.util.List;

import org.elis.dao.UtenteDao;
import org.elis.enumerazioni.Ruolo;
import org.elis.model.Tipologia;
import org.elis.model.Utente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transaction;

public class JPAUtenteDao implements UtenteDao{

	private EntityManagerFactory emf;
	
	public JPAUtenteDao(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public void insert(Utente entity) throws Exception {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(entity);
		et.commit();
	}

	@Override
	public Utente selectById(Long id) throws Exception {
		EntityManager em = emf.createEntityManager();
		return em.find(Utente.class, id);
	}

	@Override
	public List<Utente> findAll() throws Exception {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("select u from Utente u");
		List<Utente> utenti = (List<Utente>) q.getResultList();
		return utenti;
	}

	@Override
	public void delete(Utente entity) throws Exception {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(entity);
		et.commit();
	}

	@Override
	public boolean login(String email, String password) throws Exception {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT u FROM Utente u WHERE u.email = :email AND u.password = :password");
        q.setParameter("email", email);
        q.setParameter("password", password);
        
		Utente u = (Utente) q.getSingleResult();
		
		if(u!=null) {
			return true;
		} 
		return false;

	}

	@Override
	public Utente findUtenteByUsername(String username) throws Exception {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT u FROM Utente u WHERE u.username = :username");
        q.setParameter("username", username);
        
        try {
            return (Utente) q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
	}

	@Override
	public List<Utente> findUtentiByNome(String nome) throws Exception {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT u FROM Utente u WHERE u.nome = :nome");
        q.setParameter("nome", nome);
        
		List<Utente> u = (List<Utente>) q.getResultList();
		
		return u;
	}

	@Override
	public List<Utente> findUtentiByCognome(String cognome) throws Exception {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT u FROM Utente u WHERE u.cognome = :cognome");
        q.setParameter("cognome", cognome);
        
		List<Utente> u = (List<Utente>) q.getResultList();
		
		return u;
	}

	@Override
	public List<Utente> findRistoratori() throws Exception {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT u FROM Utente u WHERE u.ruolo = :ruolo");
        q.setParameter("ruolo", Ruolo.RISTORATORE);
        
		List<Utente> u = (List<Utente>) q.getResultList();
		
		return u;
	}

	public Utente findRistoranteByIndirizzo(String indirizzo) throws Exception {
	    EntityManager em = emf.createEntityManager();
	    try {
	        TypedQuery<Utente> q = em.createQuery(
	            "SELECT u FROM Utente u WHERE u.indirizzoRistorante = :indirizzo", 
	            Utente.class);
	        q.setParameter("indirizzo", indirizzo);
	        return q.getResultStream().findFirst().orElse(null); // Restituisce null se non trovato
	    } finally {
	        em.close();
	    }
	}

	@Override
	public List<Utente> findRistoranteByNome(String ristorante) throws Exception {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT u FROM Utente u WHERE u.nomeRistorante = :nome_ristorante");
        q.setParameter("nome_ristorante", ristorante);
        
		List<Utente> u = (List<Utente>) q.getResultList();
		
		return u;
	}

	@Override
	public void updatePasswordByEmail(String email, String password) throws Exception {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Query q = em.createQuery("UPDATE utente u SET u.password =:password WHERE u.email =:email");
		q.setParameter("password", password);
		q.setParameter("email", email);
		et.begin();
		q.executeUpdate();
		et.commit();
		
	}

	@Override
	public List<Utente> findRistorantiByTipologia(String tipologiaNome) throws Exception {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT t FROM Tipologia t WHERE t.nome = :nome");
		q.setParameter("nome", tipologiaNome);
		Tipologia t = (Tipologia) q.getSingleResult();
		return t.getRistoranti();

	}

	@Override
	public Utente findUtenteByLogin(String email, String password) throws Exception {
		  
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT u FROM Utente u WHERE u.email = :email AND u.password = :password");
        q.setParameter("email", email);
        q.setParameter("password", password);
        
        Utente u = (Utente) q.getSingleResult();
        
        if (u!=null) {
        	return u;
        } else {
            return null;
        }
    }
	

	@Override
	public Utente findUtenteByEmail(String email) throws Exception {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT u FROM Utente u WHERE u.email = :email");
        q.setParameter("email", email);
        
        try {
            return (Utente) q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
	}
	
	@Override
	public Double VotoMediobyIdRist(Long idRist) throws Exception{
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT AVG(r.voto) from Recensione r join Ordine o on r.ordine.id=o.id where o.ristoratore.idUtente= :idRist");
        q.setParameter("idRist", idRist);
        return (Double) q.getSingleResult();
	}
}
