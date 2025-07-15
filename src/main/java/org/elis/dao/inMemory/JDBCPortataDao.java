package org.elis.dao.inMemory;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.elis.dao.PortataDao;
import org.elis.model.Portata;

import com.mysql.cj.jdbc.MysqlDataSource;

public class JDBCPortataDao implements PortataDao {

	private DataSource dataSource;

	public JDBCPortataDao(DataSource datasource) {
		this.dataSource = datasource;
	}
	
	@Override
	public void insert(Portata entity) throws Exception {
		try(Connection connection = dataSource.getConnection()){
			String query = "insert into Portata(nome,foto,descrizione,prezzo,id_categoria) values(?,?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, entity.getNome());
			ps.setBlob(2, entity.getFoto());
			ps.setString(3, entity.getDescrizione());
			ps.setDouble(4, entity.getPrezzo());
			ps.setLong(5, entity.getIdCategoria());;
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
	            Blob foto = rs.getBlob("foto");
				String descrizione = rs.getString("descrizione");
				Double prezzo = rs.getDouble("prezzo");
				Long l = rs.getLong("id_categoria");
				p = new Portata(id, nome, foto, descrizione, prezzo, l);

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
	            Blob foto = rs.getBlob("foto");
				String descrizione = rs.getString("descrizione");
				Double prezzo= rs.getDouble("prezzo");
				p= new Portata(nome, foto, descrizione, prezzo);
				portate.add(p);
			}
		}
		return portate;
	}

	@Override
	public void delete(Portata entity) throws Exception {
		try(Connection connection = dataSource.getConnection()){
			String query = "delete from Portata where id=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setLong(1, entity.getId());
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
				Long id = rs.getLong("id");
				String descrizione = rs.getString("descrizione");
	            Blob foto = rs.getBlob("foto");
				Double prezzo = rs.getDouble("prezzo");
				Long idCategoria = rs.getLong("id_categoria");
				p = new Portata(id,nome, foto, descrizione, prezzo,idCategoria);
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
					Long idPortata = rs.getLong("id");
					String nome = rs.getString("nome");
					String descrizione = rs.getString("descrizione");
					Double prezzo = rs.getDouble("prezzo");
		            Blob foto = rs.getBlob("foto");
					Portata p = new Portata(idPortata, nome, foto, descrizione, prezzo,l);
					portate.add(p);
				}
			}
		}
		return portate;
	}
	
	public List<Portata> findPortateByNomeRistoranteOrdine(String nomeRistorante, long idOrdine) throws Exception {
	    String sql = """
	    	SELECT p.nome AS nome_portata FROM Ordine o
			JOIN Utente u ON o.id_ristorante = u.id
			JOIN Ordine_Elemento_Ordine oe ON o.id = oe.id_ordine
			JOIN Elemento_Ordine eo ON oe.id_elemento_ordine = eo.id
			JOIN Portata p ON eo.id_portata = p.id
			WHERE u.nome_ristorante = ? AND o.id = ?
	    """;

	    List<Portata> portate = new ArrayList<>();

	    try (Connection conn = dataSource.getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {
	        ps.setString(1, nomeRistorante);
	        ps.setLong(2, idOrdine);

	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            portate.add(new Portata(rs.getString("nome_portata")));
	        }
	    }

	    return portate;
	}

}
