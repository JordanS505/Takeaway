package org.elis.dao.inMemory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.elis.dao.UtenteDao;
import org.elis.enumerazioni.Ruolo;
import org.elis.model.Tipologia;
import org.elis.model.Utente;

import com.mysql.cj.jdbc.MysqlDataSource;

public class JDBCUtenteDao implements UtenteDao {

	private MysqlDataSource dataSource;
	private JDBCTipologiaDao tipologiaDao;
	
	public JDBCUtenteDao(MysqlDataSource dataSource, JDBCTipologiaDao tipologiaDao) {
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
				ps.setBytes(10, entity.getFoto());
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
				String nome = rs.getString("nome");
				String cognome = rs.getString("cognome");
				String email = rs.getString("email");
				LocalDate dataDiNascita= rs.getTimestamp("data_di_nascita").toLocalDateTime().toLocalDate();
				String username = rs.getString("username");
				String password = rs.getString("password");
				String ruolo = rs.getString("ruolo");

				if(ruolo.equalsIgnoreCase("user")) {
					u = new Utente(username, password, nome, cognome, email,dataDiNascita, Ruolo.user);
				}
				if(ruolo.equalsIgnoreCase("admin")) {
					u = new Utente(username, password, nome, cognome, email,dataDiNascita, Ruolo.admin);
				}
				if(ruolo.equalsIgnoreCase("ristoratore")) {
					u = new Utente(username, password, nome, cognome, email,dataDiNascita, Ruolo.ristoratore);
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
				String nome = rs.getString("nome");
				String cognome = rs.getString("cognome");
				String email = rs.getString("email");
				LocalDate dataDiNascita= rs.getTimestamp("data_di_nascita").toLocalDateTime().toLocalDate();
				String username = rs.getString("username");
				String password = rs.getString("password");
				String ruolo = rs.getString("ruolo");

				if(ruolo.equalsIgnoreCase("user")) {
					u = new Utente(username, password, nome, cognome, email,dataDiNascita, Ruolo.user);
				}
				if(ruolo.equalsIgnoreCase("admin")) {
					u = new Utente(username, password, nome, cognome, email,dataDiNascita, Ruolo.admin);
				}
				if(ruolo.equalsIgnoreCase("ristoratore")) {
					u = new Utente(username, password, nome, cognome, email,dataDiNascita, Ruolo.ristoratore);
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
				String nome = rs.getString("nome");
				String cognome = rs.getString("cognome");
				String email = rs.getString("email");
				LocalDate dataDiNascita= rs.getTimestamp("data_di_nascita").toLocalDateTime().toLocalDate();
				String usernameUtente = rs.getString("username");
				String password = rs.getString("password");
				String ruolo = rs.getString("ruolo");

				if(ruolo.equalsIgnoreCase("user")) {
					u = new Utente(usernameUtente, password, nome, cognome, email,dataDiNascita, Ruolo.user);
				}
				if(ruolo.equalsIgnoreCase("admin")) {
					u = new Utente(usernameUtente, password, nome, cognome, email,dataDiNascita, Ruolo.admin);
				}
				if(ruolo.equalsIgnoreCase("ristoratore")) {
					u = new Utente(usernameUtente, password, nome, cognome, email, dataDiNascita,Ruolo.ristoratore);
				}
			}
			return u;
		}
	}

	@Override
	public Utente findUtenteByEmail(String email) throws Exception {
		Utente u = null;
		try(Connection connection = dataSource.getConnection()){
			String query = "select * from Utente where email=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				String nome = rs.getString("nome");
				String cognome = rs.getString("cognome");
				String emailUtente = rs.getString("email");
				LocalDate dataDiNascita= rs.getTimestamp("data_di_nascita").toLocalDateTime().toLocalDate();
				String username = rs.getString("username");
				String password = rs.getString("password");
				String ruolo = rs.getString("ruolo");

				if(ruolo.equalsIgnoreCase("user")) {
					u = new Utente(username, password, nome, cognome, emailUtente,dataDiNascita, Ruolo.user);
				}
				if(ruolo.equalsIgnoreCase("admin")) {
					u = new Utente(username, password, nome, cognome, emailUtente,dataDiNascita, Ruolo.admin);
				}
				if(ruolo.equalsIgnoreCase("ristoratore")) {
					u = new Utente(username, password, nome, cognome, emailUtente,dataDiNascita, Ruolo.ristoratore);
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
				String nomeUtente = rs.getString("nome");
				String cognome = rs.getString("cognome");
				String email = rs.getString("email");
				LocalDate dataDiNascita= rs.getTimestamp("data_di_nascita").toLocalDateTime().toLocalDate();
				String username = rs.getString("username");
				String password = rs.getString("password");
				String ruolo = rs.getString("ruolo");

				if(ruolo.equalsIgnoreCase("user")) {
					u = new Utente(username, password, nomeUtente, cognome, email,dataDiNascita, Ruolo.user);
				}
				if(ruolo.equalsIgnoreCase("admin")) {
					u = new Utente(username, password, nomeUtente, cognome, email,dataDiNascita, Ruolo.admin);
				}
				if(ruolo.equalsIgnoreCase("ristoratore")) {
					u = new Utente(username, password, nomeUtente, cognome, email,dataDiNascita, Ruolo.ristoratore);
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
				String nome = rs.getString("nome");
				String cognomeUtente = rs.getString("cognome");
				String email = rs.getString("email");
				LocalDate dataDiNascita= rs.getTimestamp("data_di_nascita").toLocalDateTime().toLocalDate();
				String username = rs.getString("username");
				String password = rs.getString("password");
				String ruolo = rs.getString("ruolo");

				if(ruolo.equalsIgnoreCase("user")) {
					u = new Utente(username, password, nome, cognomeUtente, email,dataDiNascita, Ruolo.user);
				}
				if(ruolo.equalsIgnoreCase("admin")) {
					u = new Utente(username, password, nome, cognomeUtente, email,dataDiNascita, Ruolo.admin);
				}
				if(ruolo.equalsIgnoreCase("ristoratore")) {
					u = new Utente(username, password, nome, cognomeUtente, email,dataDiNascita, Ruolo.ristoratore);
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
	            String nome = rs.getString("nome");
	            String cognome = rs.getString("cognome");
	            String username = rs.getString("username");
	            String password = rs.getString("password");
	            String email = rs.getString("email");
	            LocalDate dataNascita = rs.getDate("data_nascita").toLocalDate();
	            String nomeRistorante = rs.getString("nome_ristorante");
	            String indirizzoRistorante = rs.getString("indirizzo");
	            byte[] foto = rs.getBytes("foto");
	            Double votoM = rs.getDouble("votom");

	            // ✅ recupero ID per join con Tipologia_Ristorante
	            long idRistoratore = rs.getLong("id");

	            // ✅ prendo le tipologie col DAO
	            List<Tipologia> tipologie = tipologiaDao.findTipologieByRistoratoreId(idRistoratore);

	            Utente u = new Utente(username, password, nome, cognome, email, dataNascita,
	                nomeRistorante, indirizzoRistorante, tipologie, foto, votoM, Ruolo.ristoratore);

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
	            String nomeRistorante = rs.getString("nome_ristorante");
	            String indirizzoRistorante = rs.getString("indirizzo");
	            Double votoM = rs.getDouble("votom");

	            String nome = rs.getString("nome");
	            String cognome = rs.getString("cognome");
	            String email = rs.getString("email");
	            String username = rs.getString("username");
	            String password = rs.getString("password");
	            LocalDate dataNascita = rs.getDate("data_nascita").toLocalDate();
	            byte[] foto = rs.getBytes("foto");

	            long idRistoratore = rs.getLong("id");
	            List<Tipologia> tipologie = tipologiaDao.findTipologieByRistoratoreId(idRistoratore);

	            ristorante = new Utente(username, password, nome, cognome, email, dataNascita,
	                    nomeRistorante, indirizzoRistorante, tipologie, foto, votoM, Ruolo.ristoratore);
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
	            String nomeRistorante = rs.getString("nome_ristorante");
	            String indirizzoRistorante = rs.getString("indirizzo");
	            Double votoM = rs.getDouble("votom");

	            String nome = rs.getString("nome");
	            String cognome = rs.getString("cognome");
	            String email = rs.getString("email");
	            String username = rs.getString("username");
	            String password = rs.getString("password");
	            LocalDate dataNascita = rs.getDate("data_nascita").toLocalDate();
	            byte[] foto = rs.getBytes("foto");

	            long idRistoratore = rs.getLong("id");
	            List<Tipologia> tipologie = tipologiaDao.findTipologieByRistoratoreId(idRistoratore);
	            
	            Utente u = new Utente(username, password, nome, cognome, email, dataNascita,
	                    nomeRistorante, indirizzoRistorante, tipologie, foto, votoM, Ruolo.ristoratore);

	            ristoranti.add(u);
	        }
	    }

	    return ristoranti;
	}

}
