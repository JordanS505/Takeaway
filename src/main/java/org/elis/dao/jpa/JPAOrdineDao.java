package org.elis.dao.jpa;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.elis.dao.OrdineDao;
import org.elis.enumerazioni.Stato;
import org.elis.model.Ordine;
import org.elis.model.Utente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class JPAOrdineDao implements OrdineDao{
	private EntityManagerFactory emf;
	
	public JPAOrdineDao(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public void insert(Ordine entity) throws Exception {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(entity);
		et.commit();		
	}

	@Override
	public Ordine selectById(Long id) throws Exception {
		EntityManager em = emf.createEntityManager();
		return em.find(Ordine.class, id);
	}

	@Override
	public List<Ordine> findAll() throws Exception {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("select o from Ordine o");
		List<Ordine> ordini = (List<Ordine>) q.getResultList();
		return ordini;
	}

	@Override
	public void delete(Ordine entity) throws Exception {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(entity);
		et.commit();		
	}

	@Override
	public Ordine selectByData(LocalDateTime data) throws Exception {
	    EntityManager em = emf.createEntityManager();
	    Query q = em.createQuery("SELECT o FROM Ordine o WHERE o.data = :data");
	    q.setParameter("data", data);
	    List<Ordine> risultati = q.getResultList();
	    return risultati.isEmpty() ? null : risultati.get(0);
	}

	@Override
	public List<Ordine> findByStato(Stato stato) throws Exception {
	    EntityManager em = emf.createEntityManager();
	    Query q = em.createQuery("SELECT o FROM Ordine o WHERE o.stato = :stato");
	    q.setParameter("stato", stato);
	    return q.getResultList();
	}

	@Override
	public List<Ordine> findByData(LocalDateTime data) throws Exception {
	    EntityManager em = emf.createEntityManager();
	    Query q = em.createQuery("SELECT o FROM Ordine o WHERE o.data = :data");
	    q.setParameter("data", data);
	    return q.getResultList();
	}


	@Override
	public List<Ordine> findOrdinibyRistoratore(String nomeRist) throws Exception {
	    EntityManager em = emf.createEntityManager();
	    Query q = em.createQuery("""
	        SELECT o FROM Ordine o 
	        JOIN o.ristoratore r 
	        WHERE r.nomeRistorante = :nomeRist
	    """);
	    q.setParameter("nomeRist", nomeRist);
	    return q.getResultList();
	}

	@Override
	public List<Long> findAllIdOrdinebyID(long idUtente) throws Exception {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("select u from Utente u where u.id=:id");
		q.setParameter("id", idUtente);
		
		Utente u = (Utente) q.getSingleResult();
		
		List<Ordine> ordini = u.getOrdini();
		List<Long> id = new ArrayList<>();
		for(Ordine o : ordini) {
			id.add(o.getId());
		}
		return id;
	}

	@Override
	public List<Long> findAllIdOrdinebyIDRistoratore(long idUtente) throws Exception {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("select u from Utente u where u.id=:id");
		q.setParameter("id", idUtente);
		
		Utente u = (Utente) q.getSingleResult();
		
		List<Ordine> ordini = u.getOrdiniRist();
		List<Long> id = new ArrayList<>();
		for(Ordine o : ordini) {
			id.add(o.getId());
		}
		return id;
	}

	@Override
	public Long inserisciOrdine(Ordine ordine) throws Exception {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(ordine);
		et.commit();	
		return ordine.getId();
	}

	@Override
	public void inserisciOrdineElementoOrdine(Long idOrdine, Long idElemento) throws Exception {
		return;
	}

	@Override
	public void updateStatoOrdine(Long idOrdine, Stato stato) throws Exception {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Query q = em.createQuery("UPDATE Ordine o SET o.stato =:stato WHERE o.id =:id");
		q.setParameter("stato", stato);
		q.setParameter("id", idOrdine);
		et.begin();
		q.executeUpdate();
		et.commit();
	}
	
}
