package org.elis.dao.inMemory;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.elis.dao.OrdineDao;
import org.elis.enumerazioni.Stato;
import org.elis.model.ElementoOrdine;
import org.elis.model.Ordine;
import org.elis.model.Utente;

import com.mysql.cj.jdbc.MysqlDataSource;

public class JDBCOrdineDao implements OrdineDao {

    private MysqlDataSource dataSource;

    public JDBCOrdineDao(MysqlDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void insert(Ordine ordine) throws Exception {
        String sql = "INSERT INTO Ordine (data, stato,id_utente,id_ristorante) VALUES (?, ?, ?, ?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setTimestamp(1, Timestamp.valueOf(ordine.getData()));
            ps.setString(2, ordine.getStato().name());
            ps.setLong(3, ordine.getCliente().getIdUtente());
            ps.setLong(4, ordine.getRistoratore().getIdUtente());
            ps.executeUpdate();
        }
    }

    @Override
    public Ordine selectById(Long id) throws Exception {
    	Ordine o = null;
		try(Connection connection = dataSource.getConnection()){
			String query = "select * from Ordine where id=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				 
				 Long idRistorante = rs.getLong("id_ristorante");
				 Long idUtente =  rs.getLong("id_utente");
				 Stato stato = Stato.valueOf(rs.getString("stato"));
				 LocalDateTime data = rs.getTimestamp("data").toLocalDateTime();
				 
			     var psRistorante = connection.prepareStatement("select * from utente where id=?");
			     psRistorante.setLong(1, idRistorante);
			     var psUtente = connection.prepareStatement("select * from utente where id=?");
			     psUtente.setLong(1, idUtente);
			     var psElementiOrdine = connection.prepareStatement("select * from elemento_ordine join ordine_elemento_ordine on id_ordine=elemento_ordine.id where id_ordine=?");
			     psElementiOrdine.setLong(1, id);
			     Utente ristorante = null;
			     Utente cliente = null;
			    
		         ResultSet rsRistorante = psRistorante.executeQuery();
		         if(rsRistorante.next()) {
		        	 ristorante = new Utente(
		        			 idRistorante,
		        			 rsRistorante.getString("nome_ristorante")
		        			 );
		         }
		         
		         ResultSet rsUtente = psUtente.executeQuery();
		         if(rsUtente.next()) {
		        	 cliente = new Utente(
		        			 idUtente,
		        			 rsUtente.getString("nome"),
		        			 rsUtente.getString("cognome")
		        			 );
		         }
		         ResultSet rsElementiOrdine = psElementiOrdine.executeQuery();
		         List<ElementoOrdine> portate = new ArrayList<>();
		         while(rsElementiOrdine.next()) {
		        	 ElementoOrdine portata = new ElementoOrdine(
		        			 rsElementiOrdine.getString("nome"),
		        			 rsElementiOrdine.getDouble("prezzo"),
		        			 rsElementiOrdine.getInt("quantita")
		        			 );
		        	 portate.add(portata);
		         }
		         o = new Ordine(id, data, stato, ristorante, cliente, portate, null);
			}
		}
		return o;
    }

    @Override
    public Ordine selectByData(LocalDateTime data) throws Exception {
        String sql = "SELECT * FROM Ordine WHERE data = ? LIMIT 1";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setTimestamp(1, Timestamp.valueOf(data));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Ordine(
                		rs.getTimestamp("data").toLocalDateTime(),
    	                Stato.valueOf(rs.getString("stato"))
                );
            }
        }
        return null;
    }

    @Override
    public List<Ordine> findAll() throws Exception {
        List<Ordine> lista = new ArrayList<>();
        String sql = "SELECT * FROM Ordine";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new Ordine(
                		rs.getTimestamp("data").toLocalDateTime(),
    	                Stato.valueOf(rs.getString("stato"))
                ));
            }
        }
        return lista;
    }

    @Override
    public void delete(Ordine ordine) throws Exception {
        String sql = "DELETE FROM Ordine WHERE data = ? AND stato = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setTimestamp(1, Timestamp.valueOf(ordine.getData()));
            ps.setString(2, ordine.getStato().name());

            ps.executeUpdate();
        }
    }

    @Override
    public List<Ordine> findByStato(Stato stato) throws Exception {
        List<Ordine> lista = new ArrayList<>();
        String sql = "SELECT * FROM Ordine WHERE stato = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, stato.name());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new Ordine(
                		rs.getTimestamp("data").toLocalDateTime(),
    	                Stato.valueOf(rs.getString("stato"))
                ));
            }
        }
        return lista;
    }

    @Override
    public List<Ordine> findByData(LocalDateTime data) throws Exception {
        List<Ordine> lista = new ArrayList<>();
        String sql = "SELECT * FROM Ordine WHERE data = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setTimestamp(1, Timestamp.valueOf(data));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new Ordine(
                		rs.getTimestamp("data").toLocalDateTime(),
    	                Stato.valueOf(rs.getString("stato"))
                ));
            }
        }
        return lista;
    }
    
    @Override
    public List<Ordine> findOrdinibyRistoratore(String nomeRist) throws Exception {
    	List<Ordine> ordini = new ArrayList<>();
    	String sql = """
    			select * from ordine
			    where nome_ristorante = ?;
    			""";
    	try(Connection conn = dataSource.getConnection();
    		PreparedStatement ps = conn.prepareStatement(sql)){
    		ps.setString(1, nomeRist);
    		ResultSet rs = ps.executeQuery();
    		while (rs.next()) {
    			ordini.add(new Ordine(
    					rs.getTimestamp("data").toLocalDateTime(),
    	                Stato.valueOf(rs.getString("stato"))
    			));
    		}
    	}
    	return ordini;
    }
    
    @Override
    public List<Long> findAllIdOrdinebyID(long idUtente) throws Exception {
        List<Long> lista = new ArrayList<>();
        String sql = "SELECT id FROM Ordine WHERE id_Utente=?";
        try (Connection conn = dataSource.getConnection()){
        	 PreparedStatement ps = conn.prepareStatement(sql);
             ps.setLong(1, idUtente);
             ResultSet rs = ps.executeQuery();
             while (rs.next()) {
                lista.add(
                		rs.getLong("id")
                		);
            }
        }
        return lista;
    }
    @Override
    public List<Long> findAllIdOrdinebyIDRistoratore(long idUtente) throws Exception {
        List<Long> lista = new ArrayList<>();
        String sql = "SELECT id FROM Ordine WHERE id_ristorante=?";
        try (Connection conn = dataSource.getConnection()){
        	 PreparedStatement ps = conn.prepareStatement(sql);
             ps.setLong(1, idUtente);
             ResultSet rs = ps.executeQuery();
             while (rs.next()) {
                lista.add(
                		rs.getLong("id")
                		);
            }
        }
        return lista;
    }
    
    @Override
    public Long inserisciOrdine(Ordine ordine) throws Exception {
        String sql = "INSERT INTO Ordine (data, stato,id_utente,id_ristorante) VALUES (?, ?, ?, ?)";
        String quey= "select id from ordine where data=? and stato=? and id_utente=? and id_ristorante=?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setTimestamp(1, Timestamp.valueOf(ordine.getData()));
            ps.setString(2, ordine.getStato().name());
            ps.setLong(3, ordine.getCliente().getIdUtente());
            ps.setLong(4, ordine.getRistoratore().getIdUtente());
            ps.executeUpdate();
            PreparedStatement ps2 = conn.prepareStatement(quey);
            ps2.setTimestamp(1, Timestamp.valueOf(ordine.getData()));
            ps2.setString(2, ordine.getStato().name());
            ps2.setLong(3, ordine.getCliente().getIdUtente());
            ps2.setLong(4, ordine.getRistoratore().getIdUtente());
            ResultSet rs = ps2.executeQuery();
            if(rs.next()) {
            	Long id = rs.getLong("id");
            	return id;
            }
        }
        return null;
    }
    
    @Override
    public void inserisciOrdineElementoOrdine(Long idOrdine,Long idElemento) throws Exception{
    	String query = "INSERT INTO ordine_elemento_ordine(id_ordine,id_elemento_ordine) VALUES(?,?)";
    	try(Connection conn = dataSource.getConnection()){
    		PreparedStatement ps = conn.prepareStatement(query);
    		ps.setLong(1, idOrdine);
    		ps.setLong(2, idElemento);
    		ps.executeQuery();
    	}
    }

}