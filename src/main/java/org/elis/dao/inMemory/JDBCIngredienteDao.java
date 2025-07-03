package org.elis.dao.inMemory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.elis.dao.IngredienteDao;
import org.elis.model.Ingrediente;

import com.mysql.cj.jdbc.MysqlDataSource;

public class JDBCIngredienteDao implements IngredienteDao {

    private MysqlDataSource dataSource;

    public JDBCIngredienteDao(MysqlDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void insert(Ingrediente ingrediente) throws Exception {
        String sql = "INSERT INTO Ingrediente (nome, senzaLattosio, senzaGlutine) VALUES (?, ?, ?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, ingrediente.getNome());
            ps.setBoolean(2, ingrediente.isSenzaLattosio());
            ps.setBoolean(3, ingrediente.isSenzaGlutine());
            ps.executeUpdate();
        }
    }

    @Override
    public Ingrediente selectById(Long id) throws Exception {
        Ingrediente ingrediente = null;
        try (Connection connection = dataSource.getConnection()) {
            String query = "SELECT * FROM Ingrediente WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String nome = rs.getString("nome");
                boolean senzaLattosio = rs.getBoolean("senzaLattosio");
                boolean senzaGlutine = rs.getBoolean("senzaGlutine");
                ingrediente = new Ingrediente(nome, senzaLattosio, senzaGlutine);
            }
        }
        return ingrediente;
    }

    @Override
    public List<Ingrediente> findAll() throws Exception {
        List<Ingrediente> lista = new ArrayList<>();
        String sql = "SELECT * FROM Ingrediente";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(mapRowToIngrediente(rs));
            }
        }
        return lista;
    }

    @Override
    public void delete(Ingrediente ingrediente) throws Exception {
        String sql = "DELETE FROM Ingrediente WHERE nome = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, ingrediente.getNome());
            ps.executeUpdate();
        }
    }

    @Override
    public Ingrediente findIngredienteByNome(String nome) throws Exception {
        String sql = "SELECT * FROM Ingrediente WHERE nome = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapRowToIngrediente(rs);
            }
        }
        return null;
    }

    @Override
    public List<Ingrediente> findIngredienteBySenzaLattosio(boolean senzaLattosio) throws Exception {
        List<Ingrediente> lista = new ArrayList<>();
        String sql = "SELECT * FROM Ingrediente WHERE senzaLattosio = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setBoolean(1, senzaLattosio);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(mapRowToIngrediente(rs));
            }
        }
        return lista;
    }

    @Override
    public List<Ingrediente> findIngredienteBySenzaGlutine(boolean senzaGlutine) throws Exception {
        List<Ingrediente> lista = new ArrayList<>();
        String sql = "SELECT * FROM Ingrediente WHERE senzaGlutine = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setBoolean(1, senzaGlutine);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(mapRowToIngrediente(rs));
            }
        }
        return lista;
    }

    private Ingrediente mapRowToIngrediente(ResultSet rs) throws SQLException {
        return new Ingrediente(
            rs.getString("nome"),
            rs.getBoolean("senzaLattosio"),
            rs.getBoolean("senzaGlutine")
        );
    }
}