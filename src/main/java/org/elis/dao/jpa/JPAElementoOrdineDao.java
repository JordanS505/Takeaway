package org.elis.dao.jpa;

import java.util.List;

import org.elis.dao.ElementoOrdineDao;
import org.elis.model.ElementoOrdine;

import jakarta.persistence.EntityManagerFactory;

public class JPAElementoOrdineDao implements ElementoOrdineDao{
	
private EntityManagerFactory emf;
	
	public JPAElementoOrdineDao(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public void insert(ElementoOrdine entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ElementoOrdine selectById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ElementoOrdine> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(ElementoOrdine entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ElementoOrdine findElementoOrdineByNome(String nome) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long inserisciElementoOrdine(ElementoOrdine EO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
