package org.elis.dao.inMemory;

import java.io.DataInputStream;
import java.io.InputStream;

import org.elis.dao.CategoriaDao;
import org.elis.dao.DaoFactory;
import org.elis.dao.ElementoOrdineDao;
import org.elis.dao.IngredienteDao;
import org.elis.dao.OrdineDao;
import org.elis.dao.PortataDao;
import org.elis.dao.RecensioneDao;
import org.elis.dao.TipologiaDao;
import org.elis.dao.UtenteDao;
import org.elis.model.Utente;

import com.mysql.cj.jdbc.MysqlDataSource;

public class JDBCDaoFactory extends DaoFactory{
	private static JDBCDaoFactory instance;
	
	public static JDBCDaoFactory getInstance() {
		if(instance==null)
			instance= new JDBCDaoFactory();
		return instance;
	}

private static MysqlDataSource dataSource;
	
	public static MysqlDataSource getDataSource() {
		if(dataSource==null) {
			dataSource = new MysqlDataSource();
			dataSource.setUser("root");
			dataSource.setPassword(getPassword());
			dataSource.setServerName("localhost");
			dataSource.setDatabaseName("Takeaway");
		}
		
		return dataSource;
	}
	
	private static String getPassword() {
		try {
			InputStream a = Utente.class.getClassLoader().getResourceAsStream("db_password");
			DataInputStream dis = new DataInputStream(a);
	        String password = dis.readLine();
			System.out.println(password);
			return password;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public UtenteDao getUtenteDao() {
	    return new JDBCUtenteDao(getDataSource(), new JDBCTipologiaDao(getDataSource()));
	}

	@Override
	public PortataDao getPortataDao() {
		return new JDBCPortataDao(getDataSource());
	}

	@Override
	public CategoriaDao getCategoriaDao() {
		return new JDBCCategoriaDao(getDataSource());
	}

	@Override
	public ElementoOrdineDao getElementoOrdineDao() {
		return new JDBCElementoOrdineDao(getDataSource());
	}

	@Override
	public IngredienteDao getIngredienteDao() {
		return new JDBCIngredienteDao(getDataSource());
	}

	@Override
	public RecensioneDao getRecensioneDao() {
		return new JDBCRecensioneDao(getDataSource());
	}

	@Override
	public TipologiaDao getTipologiaDao() {
		return new JDBCTipologiaDao(getDataSource());
	}

	@Override
	public OrdineDao getOrdineDao() {
		return new JDBCOrdineDao(getDataSource());
	}
}
