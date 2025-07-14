package org.elis.dao.inMemory;

import java.io.DataInputStream;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

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

private static DataSource dataSource;
	
	public static DataSource getDataSource() {
		if(dataSource==null) {
			MysqlDataSource md = new MysqlDataSource();
			md.setUser("root");
			md.setPassword(getPassword());
			md.setServerName("localhost");
			md.setDatabaseName("Takeaway");
			try {
				md.setServerTimezone("Europe/Rome");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dataSource=md;
		}
		//DriverManager.getConnection("jdbc:mysql://localhost:3306/Takeaway?user=root&password="+getPassword()+"&serverTimezone=Europe/Rome");
		
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
