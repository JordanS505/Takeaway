package org.elis.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import org.elis.dao.DaoFactory;
import org.elis.dao.UtenteDao;
import org.elis.enumerazioni.Ruolo;
import org.elis.model.Utente;

@WebServlet("/LogicaDiventaPartner")
@MultipartConfig(maxFileSize = 1024*10*1000, maxRequestSize = 1024*15*1000)
public class LogicaDiventaPartner extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("Nome");
		String cognome = request.getParameter("Cognome");
		String email = request.getParameter("Email");
		String username = request.getParameter("Username");
		String password = request.getParameter("Password");
		String nascita = request.getParameter("Nascita");
		String nomeRistorante = request.getParameter("Nomeristorante");
		String indirizzoRistorante = request.getParameter("Indirizzoristorante");
		List<String> categorie = new ArrayList<>();
		String[] a = request.getParameterValues("Categorie");
		Part file= request.getPart("fileFoto");
		
		byte[] arrayFile= file.getInputStream().readAllBytes();
		
		String imageString = Base64.getEncoder().encodeToString(arrayFile);
		
		PreparedStatement ps = null;
		
		try {
			ps.setBlob(1, file.getInputStream());
			
			Blob blob = new SerialBlob(arrayFile);
			
			ps.setBlob(0, blob);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(a==null) {
			response.sendRedirect(request.getContextPath()+"/DiventaPartnerServlet?error=categorieMancanti");
			return;
		}
		for(String c : a) {
			categorie.add(c);
		}
		
		UtenteDao accessoRistorante = DaoFactory.getDaoFactory().getUtenteDao();
		try {
			if(accessoRistorante.findRistoranteByIndirizzo(indirizzoRistorante)!=null) {
				response.sendRedirect(request.getContextPath()+ "/DiventaPartnerServlet?error=indirizzoEsistente");
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(!controllaVuoto(nome, cognome, username, password, email, nascita, nomeRistorante, indirizzoRistorante)) {
			response.sendRedirect(request.getContextPath() + "/DiventaPartnerServlet?error=campiMancanti");
			return;
		}
		LocalDate dataDiNascita = LocalDate.parse(nascita);
		
		if(!passwordForte(password)) {
			response.sendRedirect(request.getContextPath() + "/DiventaPartnerServlet?error=passwordErrata");
			return;
		}
		
		if(!controllaData(dataDiNascita)) {
			response.sendRedirect(request.getContextPath() + "/DiventaPartnerServlet?error=minorenne");
			return;
		}
		
		Utente u = new Utente(null, username, password, nomeRistorante, cognome, email, dataDiNascita,nomeRistorante,indirizzoRistorante,null, Ruolo.RISTORATORE);
		UtenteDao accessoUtente = DaoFactory.getDaoFactory().getUtenteDao();
		try {
			
			accessoUtente.insert(u);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private boolean controllaVuoto(String nome,String cognome,String username,String password,
			String email,String dataNascita,String nomeRistorante,String indirizzoRistorante) {
		if(nome.isBlank() || cognome.isBlank() || username.isBlank() || password.isBlank() || email.isBlank() || dataNascita.isBlank()
				|| nomeRistorante.isBlank() || indirizzoRistorante.isBlank())
			return false;
		return true;
	}
	
	private boolean passwordForte(String password) {
	    if (password == null || password.length() < 8) return false;

	    boolean haMaiuscola = password.matches(".*[A-Z].*");
	    boolean haMinuscola = password.matches(".*[a-z].*");
	    boolean haNumero = password.matches(".*\\d.*");
	    boolean haSpeciale = password.matches(".*[\\W_].*");

	    return haMaiuscola && haMinuscola && haNumero && haSpeciale;
	}

	private boolean controllaData(LocalDate data) {
		if(Period.between(data, LocalDate.now()).getYears()>17)
			return true;
		return false;
	}
	
}
