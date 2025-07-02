package org.elis.dao.inMemory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.elis.dao.UtenteDao;
import org.elis.model.Ruolo;
import org.elis.model.Utente;

import com.mysql.cj.jdbc.MysqlDataSource;

public class JDBCUtenteDao implements UtenteDao {
	
	private MysqlDataSource dataSource;
	
	public JDBCUtenteDao(MysqlDataSource datasource) {
		this.dataSource = datasource;
	}
	
	@Override
	public void insert(Utente entity) throws Exception {
		try(Connection connection = dataSource.getConnection()){
			String query = "insert into Utente(nome,cognome,username,password,email,ruolo) values(?,?,?,?,?,?)";
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
	public Utente selectById(Long id) throws Exception {
		Utente u = null;
		try(Connection connection = dataSource.getConnection()){
			String query = "select * from Utente where id=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			String nome = rs.getString("nome");
			String cognome = rs.getString("cognome");
			String email = rs.getString("email");
			String username = rs.getString("username");
			String password = rs.getString("password");
			String ruolo = rs.getString("ruolo");
			
			if(ruolo.equalsIgnoreCase("user")) {
			u = new Utente(username, password, nome, cognome, email, Ruolo.user);
			}
			if(ruolo.equalsIgnoreCase("admin")) {
				u = new Utente(username, password, nome, cognome, email, Ruolo.admin);
			}
			if(ruolo.equalsIgnoreCase("ristoratore")) {
				u = new Utente(username, password, nome, cognome, email, Ruolo.ristoratore);
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
				String username = rs.getString("username");
				String password = rs.getString("password");
				String ruolo = rs.getString("ruolo");
				
				if(ruolo.equalsIgnoreCase("user")) {
				u = new Utente(username, password, nome, cognome, email, Ruolo.user);
				}
				if(ruolo.equalsIgnoreCase("admin")) {
					u = new Utente(username, password, nome, cognome, email, Ruolo.admin);
				}
				if(ruolo.equalsIgnoreCase("ristoratore")) {
					u = new Utente(username, password, nome, cognome, email, Ruolo.ristoratore);
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
			String nome = rs.getString("nome");
			String cognome = rs.getString("cognome");
			String email = rs.getString("email");
			String usernameUtente = rs.getString("username");
			String password = rs.getString("password");
			String ruolo = rs.getString("ruolo");
			
			if(ruolo.equalsIgnoreCase("user")) {
			u = new Utente(usernameUtente, password, nome, cognome, email, Ruolo.user);
			}
			if(ruolo.equalsIgnoreCase("admin")) {
				u = new Utente(usernameUtente, password, nome, cognome, email, Ruolo.admin);
			}
			if(ruolo.equalsIgnoreCase("ristoratore")) {
				u = new Utente(usernameUtente, password, nome, cognome, email, Ruolo.ristoratore);
			}
		}
		return u;
	}

	@Override
	public Utente findUtenteByEmail(String email) throws Exception {
		Utente u = null;
		try(Connection connection = dataSource.getConnection()){
			String query = "select * from Utente where email=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			String nome = rs.getString("nome");
			String cognome = rs.getString("cognome");
			String emailUtente = rs.getString("email");
			String username = rs.getString("username");
			String password = rs.getString("password");
			String ruolo = rs.getString("ruolo");
			
			if(ruolo.equalsIgnoreCase("user")) {
			u = new Utente(username, password, nome, cognome, emailUtente, Ruolo.user);
			}
			if(ruolo.equalsIgnoreCase("admin")) {
				u = new Utente(username, password, nome, cognome, emailUtente, Ruolo.admin);
			}
			if(ruolo.equalsIgnoreCase("ristoratore")) {
				u = new Utente(username, password, nome, cognome, emailUtente, Ruolo.ristoratore);
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
				String username = rs.getString("username");
				String password = rs.getString("password");
				String ruolo = rs.getString("ruolo");
				
				if(ruolo.equalsIgnoreCase("user")) {
				u = new Utente(username, password, nomeUtente, cognome, email, Ruolo.user);
				}
				if(ruolo.equalsIgnoreCase("admin")) {
					u = new Utente(username, password, nomeUtente, cognome, email, Ruolo.admin);
				}
				if(ruolo.equalsIgnoreCase("ristoratore")) {
					u = new Utente(username, password, nomeUtente, cognome, email, Ruolo.ristoratore);
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
				String username = rs.getString("username");
				String password = rs.getString("password");
				String ruolo = rs.getString("ruolo");
				
				if(ruolo.equalsIgnoreCase("user")) {
				u = new Utente(username, password, nome, cognomeUtente, email, Ruolo.user);
				}
				if(ruolo.equalsIgnoreCase("admin")) {
					u = new Utente(username, password, nome, cognomeUtente, email, Ruolo.admin);
				}
				if(ruolo.equalsIgnoreCase("ristoratore")) {
					u = new Utente(username, password, nome, cognomeUtente, email, Ruolo.ristoratore);
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

}
