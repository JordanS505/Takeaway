package org.elis.dao.inMemory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.elis.dao.RistoranteDao;
import org.elis.model.Ristorante;

import com.mysql.cj.jdbc.MysqlDataSource;

public class JDBCRistoranteDao implements RistoranteDao {

	private MysqlDataSource dataSource;
	
	public JDBCRistoranteDao(MysqlDataSource datasource) {
		this.dataSource = datasource;
	}
	
	@Override
	public void insert(Ristorante entity) throws Exception {
		try(Connection connection = dataSource.getConnection()){
			String query = "insert into Ristorante(nome,indirizzo) values(?,?)";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, entity.getNome());
			ps.setString(2, entity.getIndirizzo());
			ps.executeUpdate();
		}

	}

	@Override
	public Ristorante selectById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ristorante> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Ristorante entity) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Ristorante findRistoranteByNome(String nome) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ristorante findRistoranteByIndirizzo(String indirizzo) throws Exception {
		try(Connection connection = dataSource.getConnection()){
			String query = "select * from ristorante where indirizzo=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, indirizzo);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				String nome = rs.getString("nome");
				String address = rs.getString("indirizzo");
				Ristorante ristorante = new Ristorante(nome,address);
				return ristorante;
			}
		}
		return null;
	}

}
