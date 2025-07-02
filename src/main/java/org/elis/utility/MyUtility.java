package org.elis.utility;

import java.io.DataInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import org.elis.model.Utente;

import com.mysql.cj.jdbc.MysqlDataSource;

public class MyUtility {
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
}
