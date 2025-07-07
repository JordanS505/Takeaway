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

    public JDBCTipologiaDao(MysqlDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void insert(Tipologia entity) throws Exception {
        try (Connection connection = dataSource.getConnection()) {
            String query = "INSERT INTO Tipologia(nome) VALUES (?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, entity.getNome());
            ps.executeUpdate();
        }
    }

    @Override
    public Tipologia selectById(Long id) throws Exception {
        Tipologia t = null;
        try (Connection connection = dataSource.getConnection()) {
            String query = "SELECT nome FROM Tipologia WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                t = new Tipologia(rs.getString("nome"));
            }
        }
        return t;
    }

    @Override
    public List<Tipologia> findAll() throws Exception {
        List<Tipologia> tipi = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            String query = "SELECT nome FROM Tipologia";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tipi.add(new Tipologia(rs.getString("nome")));
            }
        }
        return tipi;
    }

    @Override
    public void delete(Tipologia entity) throws Exception {
        try (Connection connection = dataSource.getConnection()) {
            String query = "DELETE FROM Tipologia WHERE nome = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, entity.getNome());
            ps.executeUpdate();
        }
    }

    @Override
    public Tipologia findTipologiaByNome(String nome) throws Exception {
        Tipologia t = null;
        try (Connection connection = dataSource.getConnection()) {
            String query = "SELECT nome FROM Tipologia WHERE nome = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                t = new Tipologia(rs.getString("nome"));
            }
        }
        return t;
    }

    @Override
    public List<Tipologia> findTipologieByRistoratoreId(long idRistoratore) throws Exception {
        List<Tipologia> tipologie = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            String query = """
                SELECT t.nome
                FROM Tipologia t
                JOIN Tipologia_Ristorante tr ON t.id = tr.id_tipologia
                WHERE tr.id_ristorante = ?
            """;
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setLong(1, idRistoratore);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                tipologie.add(new Tipologia(rs.getString("nome")));
            }
        }
        return tipologie;
    }
}
