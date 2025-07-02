package org.elis.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

import org.elis.dao.inMemory.JDBCUtenteDao;
import org.elis.model.Ruolo;
import org.elis.model.Utente;
import org.elis.utility.MyUtility;

@WebServlet("/LogicaRegistrazione")
public class LogicaRegistrazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("Nome");
		String cognome = request.getParameter("Cognome");
		String username = request.getParameter("Username");
		String password = request.getParameter("Password");
		String email = request.getParameter("Email");
		String dataNascita = request.getParameter("Nascita");
		LocalDate dataDiNascita=null;
		if(!controllaVuoto(nome, cognome, username, password, email, dataNascita)) {
			response.sendRedirect(request.getContextPath() + "/Registrazione?error=campiMancanti");
			return;
		}
		dataDiNascita = LocalDate.parse(dataNascita);
		if(!controllaMaiuscola(password) && !controllaSp(password)) {
			response.sendRedirect(request.getContextPath() + "/Registrazione?error=passwordErrata");
			return;
		}
		if(!controllaData(dataDiNascita)) {
			response.sendRedirect(request.getContextPath() + "/Registrazione?error=minorenne");
			return;
		}
		
		JDBCUtenteDao uDao = new JDBCUtenteDao(MyUtility.getDataSource());
		
		try {
			uDao.insert(new Utente(username, password, nome, cognome, email, Ruolo.user));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private boolean controllaVuoto(String nome,String cognome,String username,String password,
			String email,String dataNascita) {
		if(nome.isBlank() || cognome.isBlank() || username.isBlank() || password.isBlank() || email.isBlank() || dataNascita.isBlank())
			return false;
		return true;
	}
	
	private boolean controllaMaiuscola(String parola) {
		for(int i=0;i<parola.length();i++){
			if(parola.charAt(i)>='A' && parola.charAt(i)<='Z')
				return true;
		}
		return false;
	}

	private boolean controllaSp(String parola) {
		if(parola.contains("%") || parola.contains("$") || parola.contains("!")) {
			return true;
		}
		return false;
	}

	private boolean controllaData(LocalDate data) {
		if(Period.between(data, LocalDate.now()).getYears()>17)
			return true;
		return false;
	}
}
