package org.elis.dao.inMemory;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.elis.dao.OrdineDao;
import org.elis.enumerazioni.Stato;
import org.elis.model.Ordine;

import com.mysql.cj.jdbc.MysqlDataSource;

public class JDBCOrdineDao implements OrdineDao {

    private MysqlDataSource dataSource;

    public JDBCOrdineDao(MysqlDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void insert(Ordine ordine) throws Exception {
        String sql = "INSERT INTO Ordine (data, stato) VALUES (?, ?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setTimestamp(1, Timestamp.valueOf(ordine.getData()));
            ps.setString(2, ordine.getStato().name());
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
				return new Ordine(
	                rs.getTimestamp("data").toLocalDateTime(),
	                Stato.valueOf(rs.getString("stato"))
				);
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
}