package org.elis.dao.inMemory;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.elis.dao.UtenteDao;
import org.elis.enumerazioni.Ruolo;
import org.elis.model.Tipologia;
import org.elis.model.Utente;


public class JDBCUtenteDao implements UtenteDao {

	private DataSource dataSource;
	private JDBCTipologiaDao tipologiaDao;
	
	public JDBCUtenteDao(DataSource dataSource, JDBCTipologiaDao tipologiaDao) {
		this.dataSource = dataSource;
		this.tipologiaDao = tipologiaDao;
	}

	@Override
	public void insert(Utente entity) throws Exception {
		try(Connection connection = dataSource.getConnection()){
			if(entity.getNomeRistorante()==null) {
				String query = "insert into Utente(nome,cognome,username,password,email,data_nascita,ruolo) values(?,?,?,?,?,?,?)";
				PreparedStatement ps = connection.prepareStatement(query);
				ps.setString(1, entity.getNome());
				ps.setString(2, entity.getCognome());
				ps.setString(3, entity.getUsername());
				ps.setString(4, entity.getPassword());
				ps.setString(5, entity.getEmail());
				ps.setString(6, entity.getDataDiNascita().toString());
				ps.setString(7, entity.getRuolo().name());
				ps.executeUpdate();
			}
			else {
				String query = "insert into Utente(nome,cognome,username,password,email,data_nascita,ruolo,nome_ristorante,indirizzo,foto,votoM) "
						+ "values(?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement ps = connection.prepareStatement(query);
				ps.setString(1, entity.getNome());
				ps.setString(2, entity.getCognome());
				ps.setString(3, entity.getUsername());
				ps.setString(4, entity.getPassword());
				ps.setString(5, entity.getEmail());
				ps.setString(6, entity.getDataDiNascita().toString());
				ps.setString(7, entity.getRuolo().name());
				ps.setString(8, entity.getNomeRistorante());
				ps.setString(9, entity.getIndirizzoRistorante());
				ps.setBlob(10, entity.getFoto());
				ps.setDouble(11, 0);
				ps.executeUpdate();
			}
		}

	}

	@Override
	public Utente selectById(Long id) throws Exception {
		Utente u = null;
		try(Connection connection = dataSource.getConnection()){
			String query = "select * from Utente where id=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				long idUtente = rs.getLong("id");
				String nome = rs.getString("nome");
				String cognome = rs.getString("cognome");
				String email = rs.getString("email");
				LocalDate dataDiNascita= rs.getTimestamp("data_nascita").toLocalDateTime().toLocalDate();
				String username = rs.getString("username");
				String password = rs.getString("password");
				String ruolo = rs.getString("ruolo");

				if(ruolo.equalsIgnoreCase("user")) {
					u = new Utente(idUtente, username, password, nome, cognome, email,dataDiNascita, Ruolo.USER);
				}
				if(ruolo.equalsIgnoreCase("admin")) {
					u = new Utente(idUtente, username, password, nome, cognome, email,dataDiNascita, Ruolo.ADMIN);
				}
				if(ruolo.equalsIgnoreCase("ristoratore")) {
					u = new Utente(idUtente, username, password, nome, cognome, email,dataDiNascita, Ruolo.RISTORATORE);
				}
			}
		}
		return u;
	}

	@Override
	public List<Utente> findAll() throws Exception {
		List<Utente> utenti= new ArrayList<>();
		try(Connection connection = dataSource.getConnection()){
			String query = "select * from Utente";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			Utente u=null;
			while(rs.next()) {
				long idUtente = rs.getLong("id");
				String nome = rs.getString("nome");
				String cognome = rs.getString("cognome");
				String email = rs.getString("email");
				LocalDate dataDiNascita= rs.getTimestamp("data_nascita").toLocalDateTime().toLocalDate();
				String username = rs.getString("username");
				String password = rs.getString("password");
				String ruolo = rs.getString("ruolo");

				if(ruolo.equalsIgnoreCase("user")) {
					u = new Utente(idUtente, username, password, nome, cognome, email,dataDiNascita, Ruolo.USER);
				}
				if(ruolo.equalsIgnoreCase("admin")) {
					u = new Utente(idUtente, username, password, nome, cognome, email,dataDiNascita, Ruolo.ADMIN);
				}
				if(ruolo.equalsIgnoreCase("ristoratore")) {
					u = new Utente(idUtente, username, password, nome, cognome, email,dataDiNascita, Ruolo.RISTORATORE);
				}
				utenti.add(u);
			}
		}
		return utenti;
	}

	@Override
	public void delete(Utente entity) throws Exception {
		try(Connection connection = dataSource.getConnection()){
			String query = "delete from Utente where nome=? AND cognome=? AND username=? AND password=? "
					+ "AND email=? AND ruolo=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, entity.getNome());
			ps.setString(2, entity.getCognome());
			ps.setString(3, entity.getUsername());
			ps.setString(4, entity.getPassword());
			ps.setString(5, entity.getEmail());
			ps.setString(6, entity.getRuolo().name());
			ps.executeUpdate();
		}

	}

	@Override
	public Utente findUtenteByUsername(String username) throws Exception {
		Utente u = null;
		try(Connection connection = dataSource.getConnection()){
			String query = "select * from Utente where username=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				long idUtente = rs.getLong("id");
				String nome = rs.getString("nome");
				String cognome = rs.getString("cognome");
				String email = rs.getString("email");
				LocalDate dataDiNascita= rs.getTimestamp("data_nascita").toLocalDateTime().toLocalDate();
				String usernameUtente = rs.getString("username");
				String password = rs.getString("password");
				String ruolo = rs.getString("ruolo");

				if(ruolo.equalsIgnoreCase("user")) {
					u = new Utente(idUtente, usernameUtente, password, nome, cognome, email,dataDiNascita, Ruolo.USER);
				}
				if(ruolo.equalsIgnoreCase("admin")) {
					u = new Utente(idUtente, usernameUtente, password, nome, cognome, email,dataDiNascita, Ruolo.ADMIN);
				}
				if(ruolo.equalsIgnoreCase("ristoratore")) {
					u = new Utente(idUtente, usernameUtente, password, nome, cognome, email, dataDiNascita,Ruolo.RISTORATORE);
				}
			}
			return u;
		}
	}

	@Override
	public Utente findUtenteByLogin(String email, String password) throws Exception {
		Utente u = null;
		try(Connection connection = dataSource.getConnection()){
			String query = "select * from Utente where email=? AND password=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Long idUtente = rs.getLong("id");
				String nome = rs.getString("nome");
				String cognome = rs.getString("cognome");
				String emailUtente = rs.getString("email");
				LocalDate dataDiNascita= rs.getTimestamp("data_nascita").toLocalDateTime().toLocalDate();
				String username = rs.getString("username");
				String ruolo = rs.getString("ruolo");

				if(ruolo.equalsIgnoreCase("user")) {
					u = new Utente(idUtente, username, password, nome, cognome, emailUtente,dataDiNascita, Ruolo.USER);
				}
				if(ruolo.equalsIgnoreCase("admin")) {
					u = new Utente(idUtente, username, password, nome, cognome, emailUtente,dataDiNascita, Ruolo.ADMIN);
				}
				if(ruolo.equalsIgnoreCase("ristoratore")) {
					String nomeRistorante = rs.getString("nome_ristorante");
					String indirizzoRistorante = rs.getString("indirizzo");
		            List<Tipologia> tipologie = tipologiaDao.findTipologieByRistoratoreId(idUtente);
		            Blob foto = rs.getBlob("foto");
		            Double votoM = rs.getDouble("votom");
					u = new Utente(idUtente, username, password, nome, cognome, emailUtente,
							dataDiNascita, nomeRistorante, indirizzoRistorante, tipologie, foto, votoM);
				}
			}
		}
		return u;
	}
	
	@Override
	public Utente findUtenteByEmail(String email) throws Exception {
		Utente u = null;
		try(Connection connection = dataSource.getConnection()){
			String query = "select * from Utente where email=? AND password=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Long idUtente = rs.getLong("id");
				String nome = rs.getString("nome");
				String cognome = rs.getString("cognome");
				String emailUtente = rs.getString("email");
				String password = rs.getString("password");
				LocalDate dataDiNascita= rs.getTimestamp("data_nascita").toLocalDateTime().toLocalDate();
				String username = rs.getString("username");
				String ruolo = rs.getString("ruolo");

				if(ruolo.equalsIgnoreCase("user")) {
					u = new Utente(idUtente, username, password, nome, cognome, emailUtente,dataDiNascita, Ruolo.USER);
				}
				if(ruolo.equalsIgnoreCase("admin")) {
					u = new Utente(idUtente, username, password, nome, cognome, emailUtente,dataDiNascita, Ruolo.ADMIN);
				}
				if(ruolo.equalsIgnoreCase("ristoratore")) {
					String nomeRistorante = rs.getString("nome_ristorante");
					String indirizzoRistorante = rs.getString("indirizzo");
		            List<Tipologia> tipologie = tipologiaDao.findTipologieByRistoratoreId(idUtente);
		            Blob foto = rs.getBlob("foto");
		            Double votoM = rs.getDouble("votom");
					u = new Utente(idUtente, username, password, nome, cognome, emailUtente,
							dataDiNascita, nomeRistorante, indirizzoRistorante, tipologie, foto, votoM);
				}
			}
		}
		return u;
	}

	@Override
	public List<Utente> findUtentiByNome(String nome) throws Exception {
		List<Utente> utenti= new ArrayList<>();
		try(Connection connection = dataSource.getConnection()){
			String query = "select * from Utente";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			Utente u=null;
			while(rs.next()) {
				long idUtente = rs.getLong("id");
				String nomeUtente = rs.getString("nome");
				String cognome = rs.getString("cognome");
				String email = rs.getString("email");
				LocalDate dataDiNascita= rs.getTimestamp("data_nascita").toLocalDateTime().toLocalDate();
				String username = rs.getString("username");
				String password = rs.getString("password");
				String ruolo = rs.getString("ruolo");

				if(ruolo.equalsIgnoreCase("user")) {
					u = new Utente(idUtente, username, password, nomeUtente, cognome, email,dataDiNascita, Ruolo.USER);
				}
				if(ruolo.equalsIgnoreCase("admin")) {
					u = new Utente(idUtente, username, password, nomeUtente, cognome, email,dataDiNascita, Ruolo.ADMIN);
				}
				if(ruolo.equalsIgnoreCase("ristoratore")) {
					u = new Utente(idUtente, username, password, nomeUtente, cognome, email,dataDiNascita, Ruolo.RISTORATORE);
				}
				utenti.add(u);
			}
		}
		return utenti;
	}

	@Override
	public List<Utente> findUtentiByCognome(String cognome) throws Exception {
		List<Utente> utenti= new ArrayList<>();
		try(Connection connection = dataSource.getConnection()){
			String query = "select * from Utente";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			Utente u=null;
			while(rs.next()) {
				long idUtente = rs.getLong("id");
				String nome = rs.getString("nome");
				String cognomeUtente = rs.getString("cognome");
				String email = rs.getString("email");
				LocalDate dataDiNascita= rs.getTimestamp("data_nascita").toLocalDateTime().toLocalDate();
				String username = rs.getString("username");
				String password = rs.getString("password");
				String ruolo = rs.getString("ruolo");

				if(ruolo.equalsIgnoreCase("user")) {
					u = new Utente(idUtente, username, password, nome, cognomeUtente, email,dataDiNascita, Ruolo.USER);
				}
				if(ruolo.equalsIgnoreCase("admin")) {
					u = new Utente(idUtente, username, password, nome, cognomeUtente, email,dataDiNascita, Ruolo.ADMIN);
				}
				if(ruolo.equalsIgnoreCase("ristoratore")) {
					u = new Utente(idUtente, username, password, nome, cognomeUtente, email,dataDiNascita, Ruolo.RISTORATORE);
				}
				utenti.add(u);
			}
		}
		return utenti;
	}

	@Override
	public boolean login(String email, String password) throws Exception {
		try(Connection connection = dataSource.getConnection()){
			String query = "select * from Utente";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String emailUtente = rs.getString("email");
				String passwordUtente = rs.getString("password");
				if(emailUtente.equals(email) && passwordUtente.equals(password)) {
					return true;
				}
			}
		}
		return false;
	}

	public void updatePasswordByEmail(String email, String nuovaPassword) throws Exception {
		String query = "UPDATE utente SET password = ? WHERE email = ?";
		try (Connection connection = dataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setString(1, nuovaPassword);
			ps.setString(2, email);
			ps.executeUpdate();
		}
	}

	@Override
	public List<Utente> findRistoratori() throws Exception {
	    List<Utente> ristoratori = new ArrayList<>();

	    try (Connection connection = dataSource.getConnection()) {
	        String query = "SELECT * FROM Utente WHERE ruolo = 'ristoratore'";
	        PreparedStatement ps = connection.prepareStatement(query);
	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {
				long idUtente = rs.getLong("id");
	            String nome = rs.getString("nome");
	            String cognome = rs.getString("cognome");
	            String username = rs.getString("username");
	            String password = rs.getString("password");
	            String email = rs.getString("email");
	            LocalDate dataNascita = rs.getDate("data_nascita").toLocalDate();
	            String nomeRistorante = rs.getString("nome_ristorante");
	            String indirizzoRistorante = rs.getString("indirizzo");
	            Blob foto = rs.getBlob("foto");
	            Double votoM = rs.getDouble("votom");

	            long idRistoratore = rs.getLong("id");

	            List<Tipologia> tipologie = tipologiaDao.findTipologieByRistoratoreId(idRistoratore);

	            Utente u = new Utente(idUtente, username, password, nome, cognome, email, dataNascita,
	                nomeRistorante, indirizzoRistorante, tipologie, foto, votoM);

	            ristoratori.add(u);
	        }
	    }

	    return ristoratori;
	}

	@Override
	public Utente findRistoranteByIndirizzo(String indirizzo) throws Exception {
	    Utente ristorante = null;

	    try (Connection connection = dataSource.getConnection()) {
	        String query = "SELECT * FROM Utente WHERE indirizzo = ? AND ruolo = 'ristoratore'";
	        PreparedStatement ps = connection.prepareStatement(query);
	        ps.setString(1, indirizzo);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
				long idUtente = rs.getLong("id");
	            String nomeRistorante = rs.getString("nome_ristorante");
	            String indirizzoRistorante = rs.getString("indirizzo");
	            Double votoM = rs.getDouble("votom");

	            String nome = rs.getString("nome");
	            String cognome = rs.getString("cognome");
	            String email = rs.getString("email");
	            String username = rs.getString("username");
	            String password = rs.getString("password");
	            LocalDate dataNascita = rs.getDate("data_nascita").toLocalDate();
	            Blob foto = rs.getBlob("foto");

	            long idRistoratore = rs.getLong("id");
	            List<Tipologia> tipologie = tipologiaDao.findTipologieByRistoratoreId(idRistoratore);

	            ristorante = new Utente(idUtente, username, password, nome, cognome, email, dataNascita,
	                    nomeRistorante, indirizzoRistorante, tipologie, foto, votoM);
	        }
	    }

	    return ristorante;
	}

	@Override
	public List<Utente> findRistoranteByNome(String ristoranteNome) throws Exception {
	    List<Utente> ristoranti = new ArrayList<>();

	    try (Connection connection = dataSource.getConnection()) {
	        String query = "SELECT * FROM Utente WHERE ruolo = 'ristoratore' AND nome_ristorante = ?";
	        PreparedStatement ps = connection.prepareStatement(query);
	        ps.setString(1, ristoranteNome);
	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {
				long idUtente = rs.getLong("id");
	            String nomeRistorante = rs.getString("nome_ristorante");
	            String indirizzoRistorante = rs.getString("indirizzo");
	            Double votoM = rs.getDouble("votom");

	            String nome = rs.getString("nome");
	            String cognome = rs.getString("cognome");
	            String email = rs.getString("email");
	            String username = rs.getString("username");
	            String password = rs.getString("password");
	            LocalDate dataNascita = rs.getDate("data_nascita").toLocalDate();
	            Blob foto = rs.getBlob("foto");

	            long idRistoratore = rs.getLong("id");
	            List<Tipologia> tipologie = tipologiaDao.findTipologieByRistoratoreId(idRistoratore);
	            
	            Utente u = new Utente(idUtente, username, password, nome, cognome, email, dataNascita,
	                    nomeRistorante, indirizzoRistorante, tipologie, foto, votoM);

	            ristoranti.add(u);
	        }
	    }

	    return ristoranti;
	}
	
	@Override
	public List<Utente> findRistoranteByTipologia(String tipologiaNome) throws Exception {
	    List<Utente> ristoranti = new ArrayList<>();

	    try (Connection connection = dataSource.getConnection()) {
	        String query = "SELECT u.* FROM Utente u "
	                     + "JOIN Ristoratore_Tipologia rt ON u.id = rt.ristoratore_id "
	                     + "JOIN Tipologia t ON rt.tipologia_id = t.id "
	                     + "WHERE u.ruolo = 'ristoratore' AND t.nome = ?";
	        PreparedStatement ps = connection.prepareStatement(query);
	        ps.setString(1, tipologiaNome);
	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {
				long idUtente = rs.getLong("id");
	            String nomeRistorante = rs.getString("nome_ristorante");
	            String indirizzoRistorante = rs.getString("indirizzo");
	            Double votoM = rs.getDouble("votom");

	            String nome = rs.getString("nome");
	            String cognome = rs.getString("cognome");
	            String email = rs.getString("email");
	            String username = rs.getString("username");
	            String password = rs.getString("password");
	            LocalDate dataNascita = rs.getDate("data_nascita").toLocalDate();
	            Blob foto = rs.getBlob("foto");

	            long idRistoratore = rs.getLong("id");
	            List<Tipologia> tipologie = tipologiaDao.findTipologieByRistoratoreId(idRistoratore);

	            Utente u = new Utente(idUtente, username, password, nome, cognome, email, dataNascita,
	                    nomeRistorante, indirizzoRistorante, tipologie, foto, votoM);

	            ristoranti.add(u);
	        }
	    }

	    return ristoranti;
	}

	
}
