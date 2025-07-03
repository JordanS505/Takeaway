package org.elis.dao.inMemory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.elis.dao.ElementoOrdineDao;
import org.elis.model.ElementoOrdine;

import com.mysql.cj.jdbc.MysqlDataSource;

public class JDBCElementoOrdineDao implements ElementoOrdineDao {

    private MysqlDataSource dataSource;

    public JDBCElementoOrdineDao(MysqlDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void insert(ElementoOrdine entity) throws Exception {
        String sql = "INSERT INTO Elemento_Ordine (nome, prezzo, quantita) VALUES (?, ?, ?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, entity.getNome());
            ps.setDouble(2, entity.getPrezzo());
            ps.setInt(3, entity.getQuantita());
            ps.executeUpdate();
        }
    }

    @Override
    public ElementoOrdine selectById(Long id) throws Exception {
        ElementoOrdine elemento = null;
        try (Connection connection = dataSource.getConnection()) {
            String query = "SELECT * FROM Elemento_Ordine WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String nome = rs.getString("nome");
                Double prezzo = rs.getDouble("prezzo");
                int quantita = rs.getInt("quantita");
                elemento = new ElementoOrdine(nome, prezzo, quantita);
            }
        }
        return elemento;
    }

    @Override
    public List<ElementoOrdine> findAll() throws Exception {
        List<ElementoOrdine> lista = new ArrayList<>();
        String sql = "SELECT * FROM Elemento_Ordine";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String nome = rs.getString("nome");
                Double prezzo = rs.getDouble("prezzo");
                int quantita = rs.getInt("quantita");
                ElementoOrdine elemento = new ElementoOrdine(nome, prezzo, quantita);
                lista.add(elemento);
            }
        }
        return lista;
    }

    @Override
    public void delete(ElementoOrdine entity) throws Exception {
        String sql = "DELETE FROM Elemento_Ordine WHERE nome = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, entity.getNome());
            ps.executeUpdate();
        }
    }

    @Override
    public ElementoOrdine findElementoOrdineByNome(String nome) throws Exception {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM Elemento_Ordine WHERE nome = ?")) {
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String nomeDb = rs.getString("nome");
                Double prezzo = rs.getDouble("prezzo");
                int quantita = rs.getInt("quantita");
                return new ElementoOrdine(nomeDb, prezzo, quantita);
            }
        }
        return null;
    }

}