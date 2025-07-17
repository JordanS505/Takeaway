package org.elis.dao.jpa;

import java.util.List;

import org.elis.dao.TipologiaDao;
import org.elis.model.Tipologia;

import jakarta.persistence.EntityManagerFactory;

public class JPATipologiaDao implements TipologiaDao{
	
private EntityManagerFactory emf;
	
	public JPATipologiaDao(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public void insert(Tipologia entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Tipologia selectById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tipologia> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Tipologia entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Tipologia findTipologiaByNome(String nome) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tipologia> findTipologieByRistoratoreId(long idRistoratore) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
