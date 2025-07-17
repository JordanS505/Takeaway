package org.elis.dao;

import org.elis.dao.inMemory.JDBCDaoFactory;
import org.elis.dao.jpa.JPADaoFactory;

public abstract class DaoFactory {
	
	private static DaoFactory instance;
	private static final String IMPL = "JPA";
	
	
	public static DaoFactory getDaoFactory() {
		if(instance==null) {
			switch(IMPL) {
			case "JDBC":
				instance = JDBCDaoFactory.getInstance();
				break;
			case "JPA":
				instance = JPADaoFactory.getInstance();
			}
		}
		return instance;
	}
	
	public abstract UtenteDao getUtenteDao();
	public abstract PortataDao getPortataDao();
	public abstract CategoriaDao getCategoriaDao();
	public abstract ElementoOrdineDao getElementoOrdineDao();
	public abstract RecensioneDao getRecensioneDao();
	public abstract TipologiaDao getTipologiaDao();
	public abstract OrdineDao getOrdineDao();
}
