package org.elis.dao.inMemory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.elis.dao.CategoriaDao;
import org.elis.model.Categoria;

import com.mysql.cj.jdbc.MysqlDataSource;

public class JDBCCategoriaDao implements CategoriaDao {
	
	private MysqlDataSource dataSource;
	
	public JDBCCategoriaDao(MysqlDataSource datasource) {
		this.dataSource = datasource;
	}

	@Override
	public void insert(Categoria entity) throws Exception {
		try(Connection connection = dataSource.getConnection()){
			String query = "insert into Categoria(nome) values(?)";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, entity.getNome());
			ps.executeUpdate();
		}
	}

	@Override
	public Categoria selectById(Long id) throws Exception {
		Categoria c = null;
		try(Connection connection = dataSource.getConnection()){
			String query = "select * from Categoria where id=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				String nome = rs.getString("nome");
			
				c = new Categoria(nome);
			}
		}
		return c;
	}

	@Override
	public List<Categoria> findAll() throws Exception {
	    List<Categoria> categorie = new ArrayList<>();
	    try (Connection connection = dataSource.getConnection()) {
	        String query = "SELECT * FROM Categoria";
	        PreparedStatement ps = connection.prepareStatement(query);
	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {
				String nome = rs.getString("nome");
	            Categoria c = new Categoria(nome);
	            categorie.add(c);
	        }
	    }
	    return categorie;
	}

	@Override
	public void delete(Categoria entity) throws Exception {
		try(Connection connection = dataSource.getConnection()){
			String query = "delete from Utente where nome=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, entity.getNome());
			ps.executeUpdate();
		}

	}

	@Override
	public Categoria findCategoriaByNome(String nome) throws Exception {
		Categoria c = null;
		try(Connection connection = dataSource.getConnection()){
			String query = "select * from Categoria where Nome=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, nome);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				nome = rs.getString("nome");
				
				c = new Categoria(nome);
			}
			
		}
		return c;
	}

}
