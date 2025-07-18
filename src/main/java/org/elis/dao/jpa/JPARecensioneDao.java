package org.elis.dao.jpa;

import java.util.List;

import org.elis.dao.RecensioneDao;
import org.elis.model.Ordine;
import org.elis.model.Recensione;
import org.elis.model.Utente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

	public class JPARecensioneDao implements RecensioneDao{
		private EntityManagerFactory emf;
	
	public JPARecensioneDao(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public void insert(Recensione entity) throws Exception {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(entity);
		et.commit();		
	}

	@Override
	public Recensione selectById(Long id) throws Exception {
		EntityManager em = emf.createEntityManager();
		return em.find(Recensione.class, id);
	}

	@Override
	public List<Recensione> findAll() throws Exception {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("select r from Recensione r");
		List<Recensione> recensioni = (List<Recensione>) q.getResultList();
		return recensioni;
	}

	@Override
	public void delete(Recensione entity) throws Exception {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(entity);
		et.commit();		
	}

	@Override
	public List<Recensione> findRecensioniByVoto(Double voto) throws Exception {
	    EntityManager em = emf.createEntityManager();
	    Query q = em.createQuery("SELECT r FROM Recensione r WHERE r.voto = :voto");
	    q.setParameter("voto", voto);
	    return (List<Recensione>) q.getResultList();
	    
	}

	@Override
	public List<Recensione> findRecensioniByUtente(Utente u) throws Exception {
	    EntityManager em = emf.createEntityManager();
	    Query q = em.createQuery("SELECT r FROM Recensione r WHERE r.utente = :utente");
	    q.setParameter("utente", u);
	    return (List<Recensione>) q.getResultList();
	}


}
