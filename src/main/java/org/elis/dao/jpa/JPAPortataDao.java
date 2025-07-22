package org.elis.dao.jpa;

import java.util.ArrayList;
import java.util.List;

import org.elis.dao.DaoFactory;
import org.elis.dao.ElementoOrdineDao;
import org.elis.dao.PortataDao;
import org.elis.model.Categoria;
import org.elis.model.ElementoOrdine;
import org.elis.model.Portata;
import org.elis.model.Utente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class JPAPortataDao implements PortataDao {
	
	private EntityManagerFactory emf;
	
	public JPAPortataDao(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	@Override
	public void insert(Portata entity) throws Exception {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(entity);
		et.commit();
	}

	@Override
	public Portata selectById(Long id) throws Exception {
		EntityManager em = emf.createEntityManager();
		return em.find(Portata.class, id);
	}

	@Override
	public List<Portata> findAll() throws Exception {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("select p from Portata p");
		List<Portata> portate = (List<Portata>) q.getResultList();
		return portate;
	}

	@Override
	public void delete(Long id) throws Exception {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Query q = em.createQuery("DELETE FROM Portata p WHERE p.id = :id");
	    q.setParameter("id", id);
	    et.begin();
        q.executeUpdate();
		et.commit();
	}
	
	@Override
	public void delete(Portata p) throws Exception {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Portata p1= em.find(Portata.class, p.getId());
		detachIdPortata(p1);
		et.begin();
		em.remove(p1);
		et.commit();
	}
	
	public void detachIdPortata(Portata p) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Query q = em.createQuery("UPDATE ElementoOrdine eo SET eo.portata.id = null WHERE eo.portata.id = :id");
		q.setParameter("id", p.getId());
		et.begin();
		q.executeUpdate();
		et.commit();
	}
	
	@Override
	public Portata findPortataByNome(String nome) throws Exception {
		EntityManager em = emf.createEntityManager();
		return em.createQuery("SELECT p FROM Portata p WHERE p.nome = :nome", Portata.class)
                .setParameter("nome", nome)
                .getResultList()
                .stream()
                .findFirst()
                .orElse(null);
	}

	@Override
	public List<Portata> findPortataByCategoria(List<Long> id) throws Exception {
		List<Portata> portate = new ArrayList<>();
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT c FROM Categoria c WHERE c.id = :id");
		for(Long l : id) {
			q.setParameter("id", l);
			Categoria c = (Categoria)q.getSingleResult();
			portate.addAll(c.getPortate());
		}
		return portate;
	}

	@Override
	public List<Portata> findPortateByNomeRistoranteOrdine(String nomeRistorante, long idOrdine) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
