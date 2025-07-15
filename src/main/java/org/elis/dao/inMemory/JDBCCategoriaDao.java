package org.elis.dao.inMemory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.elis.dao.CategoriaDao;
import org.elis.model.Categoria;

public class JDBCCategoriaDao implements CategoriaDao {
	
	private DataSource dataSource;
	
	public JDBCCategoriaDao(DataSource datasource) {
		this.dataSource = datasource;
	}

	@Override
	public void insert(Categoria entity) throws Exception {
		try(Connection connection = dataSource.getConnection()){
			String query = "insert into Categoria(nome, id_ristorante) values (?, ?)";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, entity.getNome());
			ps.setLong(2,entity.getId_Ristorante());
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
				Long idRist = rs.getLong("id_ristorante");
				c = new Categoria(id, nome, idRist);
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
	        Categoria c = null;
	        while (rs.next()) {
	        	Long id = rs.getLong("id");
	        	String nome = rs.getString("nome");
				Long idRist = rs.getLong("id_ristorante");
				c = new Categoria(id, nome, idRist);
	            categorie.add(c);
	        }
	    }
	    return categorie;
	}

	@Override
	public void delete(Categoria entity) throws Exception {
		try(Connection connection = dataSource.getConnection()){
			String query = "delete from Utente where id=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setLong(1, entity.getId());
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
				Long id = rs.getLong("id");
				Long idRist = rs.getLong("id_ristorante");
				c = new Categoria(id, nome, idRist);
			}
			
		}
		return c;
	}
	@Override
	public List<Categoria> findCategorieByIdRistorante(Long idRist) throws Exception{
		List<Categoria> idCategorieRistorante = new ArrayList<>();
		try(Connection connection = dataSource.getConnection()){
			String query = "select * from Categoria where id_ristorante=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setLong(1, idRist);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Long id = rs.getLong("id");
	        	String nome = rs.getString("nome");
				Categoria c = new Categoria(id, nome, idRist);
				idCategorieRistorante.add(c);
			}
		}
		return idCategorieRistorante;
	}
	
	public List<Categoria> findCategorieByIndirizzoRistorante(String indirizzo) throws Exception {
	    List<Categoria> categorie = new ArrayList<>();
	    String sql = "SELECT * FROM Categoria c "
	               + "JOIN Utente u ON c.id_ristorante = u.id "
	               + "WHERE u.indirizzo = ? AND u.ruolo = 'RISTORATORE'";

	    try (Connection conn = dataSource.getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {

	        ps.setString(1, indirizzo);

	        try (ResultSet rs = ps.executeQuery()) {
	            while (rs.next()) {
	            	Long id = rs.getLong("id");
		        	String nome = rs.getString("nome");
					Long idRist = rs.getLong("id_ristorante");
					Categoria cat = new Categoria(id, nome, idRist);
	                categorie.add(cat);
	            }
	        }
	    }
	    return categorie;
	}
}
