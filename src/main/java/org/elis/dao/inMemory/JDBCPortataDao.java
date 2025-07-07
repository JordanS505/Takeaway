package org.elis.dao.inMemory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.elis.dao.PortataDao;
import org.elis.model.Portata;

import com.mysql.cj.jdbc.MysqlDataSource;

public class JDBCPortataDao implements PortataDao {

	private MysqlDataSource dataSource;

	public JDBCPortataDao(MysqlDataSource datasource) {
		this.dataSource = datasource;
	}
	
	@Override
	public void insert(Portata entity) throws Exception {
		try(Connection connection = dataSource.getConnection()){
			String query = "insert into Portata(nome,descrizione,prezzo) values(?,?,?)";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, entity.getNome());
			ps.setString(2, entity.getDescrizione());
			ps.setDouble(3, entity.getPrezzo());
			ps.executeUpdate();
		}
	}

	@Override
	public Portata selectById(Long id) throws Exception {
		Portata p = null;
		try(Connection connection = dataSource.getConnection()){
			String query = "select * from Portata where id=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				String nome = rs.getString("nome");
				String descrizione = rs.getString("cognome");
				Double prezzo = rs.getDouble("email");
				p = new Portata(nome, descrizione, prezzo);	
			}
		}
		return p;
	}

	@Override
	public List<Portata> findAll() throws Exception {
		List<Portata> portate= new ArrayList<>();
		try(Connection connection = dataSource.getConnection()){
			String query = "select * from Portata";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			Portata p=null;
			while(rs.next()) {
				String nome = rs.getString("nome");
				String descrizione = rs.getString("descrizione");
				Double prezzo= rs.getDouble("prezzo");
				p= new Portata(nome, descrizione, prezzo);
				portate.add(p);
			}
		}
		return portate;
	}

	@Override
	public void delete(Portata entity) throws Exception {
		try(Connection connection = dataSource.getConnection()){
			String query = "delete from Portata where nome=? AND descrizione=? AND prezzo=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, entity.getNome());
			ps.setString(2, entity.getDescrizione());
			ps.setDouble(3, entity.getPrezzo());
			ps.executeUpdate();
		}

	}

	@Override
	public Portata findPortataByNome(String nome) throws Exception {
		Portata p = null;
		try(Connection connection = dataSource.getConnection()){
			String query = "select * from portata where nome=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, nome);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				String descrizione = rs.getString("descrizione");
				Double prezzo = rs.getDouble("prezzo");
				p = new Portata(nome, descrizione, prezzo);
			}
		}
		return p;
	}

	@Override
	public List<Portata> findPortataByCategoria(List<Long> id) throws Exception {
		List<Portata> portate = new ArrayList<Portata>();
		try (Connection connection = dataSource.getConnection()){
			String query = "select * from portata where id_categoria=?";
			PreparedStatement ps = connection.prepareStatement(query);
			for(Long l : id) {
				ps.setLong(1, l);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					String nome = rs.getString("nome");
					String descrizione = rs.getString("descrizione");
					Double prezzo = rs.getDouble("prezzo");
					Portata p = new Portata(nome, descrizione, prezzo,l);
					portate.add(p);
				}
			}
		}
		return portate;
	}

}
