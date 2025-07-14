package org.elis.dao.inMemory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.elis.dao.CategoriaDao;
import org.elis.model.Categoria;

import com.mysql.cj.jdbc.MysqlDataSource;

public class JDBCCategoriaDao implements CategoriaDao {
	
	private DataSource dataSource;
	
	public JDBCCategoriaDao(DataSource datasource) {
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
	@Override
	public List<Categoria> findCategorieByIdRistorante(Long id) throws Exception{
		List<Categoria> idCategorieRistorante = new ArrayList<>();
		try(Connection connection = dataSource.getConnection()){
			String query = "select * from Categoria where id_ristorante=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String nome = rs.getString("nome");
				Long idCategoria = rs.getLong("id");
				Categoria c = new Categoria(nome, idCategoria);
				idCategorieRistorante.add(c);
			}
		}
		return idCategorieRistorante;
	}
	
	public List<Categoria> findCategorieByIndirizzoRistorante(String indirizzo) throws Exception {
	    List<Categoria> categorie = new ArrayList<>();
	    String sql = "SELECT c.id, c.nome FROM Categoria c "
	               + "JOIN Utente u ON c.id_ristorante = u.id "
	               + "WHERE u.indirizzo = ? AND u.ruolo = 'ristoratore'";

	    try (Connection conn = dataSource.getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {

	        ps.setString(1, indirizzo);

	        try (ResultSet rs = ps.executeQuery()) {
	            while (rs.next()) {
	                Categoria cat = new Categoria(rs.getString("nome"), rs.getLong("id"));
	                categorie.add(cat);
	            }
	        }
	    }
	    return categorie;
	}
}
