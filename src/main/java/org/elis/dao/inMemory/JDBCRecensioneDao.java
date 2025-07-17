package org.elis.dao.inMemory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.elis.dao.RecensioneDao;
import org.elis.model.Recensione;
import org.elis.model.Utente;

import com.mysql.cj.jdbc.MysqlDataSource;

public class JDBCRecensioneDao implements RecensioneDao {

	private DataSource dataSource;

	public JDBCRecensioneDao(DataSource datasource) {
		this.dataSource = datasource;
	}
	
	@Override
	public void insert(Recensione entity) throws Exception {
		try(Connection connection = dataSource.getConnection()){
			String query = "insert into Recensione(voto,testo,id_ordine,id_utente) values(?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setDouble(1, entity.getVoto());
			ps.setString(2, entity.getTesto());
			ps.setLong(3, entity.getIdOrdine());
			ps.setLong(4, entity.getIdUtente());
			ps.executeUpdate();
		}

	}

	@Override
	public Recensione selectById(Long id) throws Exception {
		Recensione r = null;
		try(Connection connection = dataSource.getConnection()){
			String query = "select * from Recensione where id=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Long idUtente = rs.getLong("id_utente");
				Double voto= rs.getDouble("voto");
				String testo = rs.getString("testo");
				r= new Recensione(voto,testo, id, idUtente);
			}
		}
		return r;
	}

	@Override
	public List<Recensione> findAll() throws Exception {
		List<Recensione> recensioni = new ArrayList<Recensione>();
		try(Connection connection = dataSource.getConnection()){
			String query ="select * from recensione";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs =  ps.executeQuery();
			while(rs.next()) {
				Long id =rs.getLong("id");
				Long idUtente = rs.getLong("id_utente");
				Double voto= rs.getDouble("voto");
				String testo = rs.getString("testo");
				Recensione r= new Recensione(voto,testo, id, idUtente);
				recensioni.add(r);
			}
		}
		return recensioni;
	}

	@Override
	public void delete(Recensione entity) throws Exception {
		try(Connection connection = dataSource.getConnection()){
			String query = "delete from recensione where voto=? AND testo=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setDouble(1, entity.getVoto());
			ps.setString(2, entity.getTesto());
			ps.executeUpdate();
		}

	}

	@Override
	public List<Recensione> findRecensioniByVoto(Double voto) throws Exception {
		List<Recensione> recensioni = new ArrayList<Recensione>();
		try(Connection connection = dataSource.getConnection()){
			String query ="select * from recensione where voto=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setDouble(1, voto);
			ResultSet rs =  ps.executeQuery();
			while(rs.next()) {
				Long id =rs.getLong("id");
				Long idUtente = rs.getLong("id_utente");
				String testo = rs.getString("testo");
				Recensione r= new Recensione(voto,testo, id, idUtente);
				recensioni.add(r);
			}
		}
		return recensioni;
	}

	@Override
	public List<Recensione> findRecensioniByUtente(Utente u) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Recensione> findRecensioniByOrdine() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
