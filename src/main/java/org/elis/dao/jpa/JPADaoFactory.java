package org.elis.dao.jpa;

import org.elis.dao.CategoriaDao;
import org.elis.dao.DaoFactory;
import org.elis.dao.ElementoOrdineDao;
import org.elis.dao.IngredienteDao;
import org.elis.dao.OrdineDao;
import org.elis.dao.PortataDao;
import org.elis.dao.RecensioneDao;
import org.elis.dao.TipologiaDao;
import org.elis.dao.UtenteDao;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPADaoFactory extends DaoFactory{


	public JPADaoFactory() {}

	private static JPADaoFactory instance = new JPADaoFactory();

	public static JPADaoFactory getInstance() {
		return instance;
	}

	private final EntityManagerFactory emf = createEntityManagerFactory();
	private EntityManagerFactory createEntityManagerFactory() {
		return Persistence.createEntityManagerFactory("Takeaway");
	}

	@Override
	public UtenteDao getUtenteDao() {
		return new JPAUtenteDao(emf);
	}

	@Override
	public PortataDao getPortataDao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoriaDao getCategoriaDao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ElementoOrdineDao getElementoOrdineDao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IngredienteDao getIngredienteDao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RecensioneDao getRecensioneDao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipologiaDao getTipologiaDao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrdineDao getOrdineDao() {
		// TODO Auto-generated method stub
		return null;
	}
}
