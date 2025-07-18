package org.elis.dao.jpa;

import java.util.List;

import org.elis.dao.TipologiaDao;
import org.elis.model.Tipologia;
import org.elis.model.Utente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class JPATipologiaDao implements TipologiaDao{
	
private EntityManagerFactory emf;
	
	public JPATipologiaDao(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public void insert(Tipologia entity) throws Exception {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(entity);
		et.commit();		
	}

	@Override
	public Tipologia selectById(Long id) throws Exception {
		EntityManager em = emf.createEntityManager();
		return em.find(Tipologia.class, id);
	}

	@Override
	public List<Tipologia> findAll() throws Exception {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("select t from Tipologia t");
		List<Tipologia> tipologie = (List<Tipologia>) q.getResultList();
		return tipologie;
	}

	@Override
	public void delete(Tipologia entity) throws Exception {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(entity);
		et.commit();		
	}

	@Override
	public Tipologia findTipologiaByNome(String nome) throws Exception {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT t FROM Tipologia t WHERE t.nome = :nome");
        q.setParameter("nome", nome);
        
		Tipologia t = (Tipologia) q.getSingleResult();
		
		return t;
	}

	@Override
	public List<Tipologia> findTipologieByRistoratoreId(long idRistoratore) throws Exception {
	    EntityManager em = emf.createEntityManager();
	    Query q = em.createQuery("SELECT t FROM Tipologia t JOIN t.ristoranti r WHERE r.idUtente = :idRistoratore");
	    q.setParameter("idRistoratore", idRistoratore);
	    return q.getResultList();
	   
	}

}
