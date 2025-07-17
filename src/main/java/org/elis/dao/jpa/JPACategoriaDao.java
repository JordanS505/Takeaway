package org.elis.dao.jpa;

import java.util.List;

import org.elis.dao.CategoriaDao;
import org.elis.model.Categoria;
import org.elis.model.Tipologia;
import org.elis.model.Utente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class JPACategoriaDao implements CategoriaDao {
	
	private EntityManagerFactory emf;
	
	public JPACategoriaDao(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	@Override
	public void insert(Categoria entity) throws Exception {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(entity);
		et.commit();
	}

	@Override
	public Categoria selectById(Long id) throws Exception {
		EntityManager em = emf.createEntityManager();
		return em.find(Categoria.class, id);
	}

	@Override
	public List<Categoria> findAll() throws Exception {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("select c from Categoria c");
		List<Categoria> categorie = (List<Categoria>) q.getResultList();
		return categorie;
	}

	@Override
	public void delete(Categoria entity) throws Exception {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(entity);
		et.commit();
	}

	@Override
	public Categoria findCategoriaByNome(String nome) throws Exception {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT c FROM Categoria u WHERE u.nome = :nome");
        q.setParameter("nome", nome);
        
		Categoria c = (Categoria) q.getSingleResult();
		
		return c;
	}

	@Override
	public List<Categoria> findCategorieByIndirizzoRistorante(String indirizzo) throws Exception {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT u FROM Utente u WHERE u.indirizzo = :indirizzo");
        q.setParameter("indirizo", indirizzo);
        
        Utente u = (Utente) q.getSingleResult();
        return u.getCategorie();
    }

}
