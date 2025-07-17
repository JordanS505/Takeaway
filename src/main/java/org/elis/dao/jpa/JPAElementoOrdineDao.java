package org.elis.dao.jpa;

import java.util.List;

import org.elis.dao.ElementoOrdineDao;
import org.elis.model.ElementoOrdine;
import org.elis.model.Utente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class JPAElementoOrdineDao implements ElementoOrdineDao{
	
private EntityManagerFactory emf;
	
	public JPAElementoOrdineDao(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public void insert(ElementoOrdine entity) throws Exception {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(entity);
		et.commit();		
	}

	@Override
	public ElementoOrdine selectById(Long id) throws Exception {
		EntityManager em = emf.createEntityManager();
		return em.find(ElementoOrdine.class, id);
	}

	@Override
	public List<ElementoOrdine> findAll() throws Exception {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("select eo from ElementoOrdine eo");
		List<ElementoOrdine> elementiOrdine = (List<ElementoOrdine>) q.getResultList();
		return elementiOrdine;
	}

	@Override
	public void delete(ElementoOrdine entity) throws Exception {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(entity);
		et.commit();		
	}

	@Override
	public ElementoOrdine findElementoOrdineByNome(String nome) throws Exception {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT eo FROM ElementoOrdine eo WHERE eo.nome = :nome");
        q.setParameter("nome", nome);
        
		ElementoOrdine eo = (ElementoOrdine) q.getResultList();
		
		return eo;
	}

	@Override
	public Long inserisciElementoOrdine(ElementoOrdine EO) throws Exception {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(EO);
		et.commit();
		
		return EO.getId();
	}

}
