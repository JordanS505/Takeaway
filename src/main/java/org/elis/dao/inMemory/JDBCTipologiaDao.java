package org.elis.dao.inMemory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.elis.dao.TipologiaDao;
import org.elis.model.Tipologia;

import com.mysql.cj.jdbc.MysqlDataSource;

public class JDBCTipologiaDao implements TipologiaDao {

	private MysqlDataSource dataSource;

	public JDBCTipologiaDao(MysqlDataSource datasource) {
		this.dataSource = datasource;
	}
	
	@Override
	public void insert(Tipologia entity) throws Exception {
		try(Connection connection = dataSource.getConnection()){
			String query = "insert into Tipologia(nome) values(?)";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, entity.getNome());
			ps.executeUpdate();
		}

	}

	@Override
	public Tipologia selectById(Long id) throws Exception {
		Tipologia t = null;
		try(Connection connection = dataSource.getConnection()){
			String query = "select * from Tipologia where id=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				String nome = rs.getString("nome");
				t= new Tipologia(nome);
			}
		}
		return t;
	}

	@Override
	public List<Tipologia> findAll() throws Exception {
		List<Tipologia> tipi = new ArrayList<>();
		try(Connection connection = dataSource.getConnection()){
			String query = "select * from Tipologia";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String nome = rs.getString("nome");
				Tipologia t= new Tipologia(nome);
				tipi.add(t);
			}
		}
		return tipi;
	}

	@Override
	public void delete(Tipologia entity) throws Exception {
		try(Connection connection = dataSource.getConnection()){
			String query = "delete from Tipologia where nome=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, entity.getNome());
			ps.executeUpdate();
		}
	}

	@Override
	public Tipologia findTipologiaByNome(String nome) throws Exception {
		Tipologia t=null;
		try(Connection connection = dataSource.getConnection()){
			String query = "select * from Tipologia where nome=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, nome);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				t=new Tipologia(nome);
			}
		}
		return t;
	}

}
