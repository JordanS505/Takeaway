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
		String confirmPassword = request.getParameter("confirmPassword");
		String email = request.getParameter("Email");
		String dataNascita = request.getParameter("Nascita");
		LocalDate dataDiNascita=null;
		
		if(!controllaVuoto(nome, cognome, username, password, confirmPassword, email, dataNascita)) {
			response.sendRedirect(request.getContextPath() + "/Registrazione?error=campiMancanti");
			return;
		}
		
		JDBCUtenteDao uDao = new JDBCUtenteDao(MyUtility.getDataSource());
		
		try {
			if (uDao.findUtenteByUsername(username) != null) {
				response.sendRedirect(request.getContextPath() + "/Registrazione?error=utenteEsistente");
				return;
			}

			if (uDao.findUtenteByEmail(email) != null) {
				response.sendRedirect(request.getContextPath() + "/Registrazione?error=emailEsistente");
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		dataDiNascita = LocalDate.parse(dataNascita);
		if(!controllaData(dataDiNascita)) {
			response.sendRedirect(request.getContextPath() + "/Registrazione?error=minorenne");
			return;
		}
		
		if(!passwordForte(password)) {
			response.sendRedirect(request.getContextPath() + "/Registrazione?error=passwordDebole");
			return;
		}
		
		if (password == null || confirmPassword == null || !password.equals(confirmPassword)) {
			response.sendRedirect(request.getContextPath() + "/Registrazione?error=pswNC");
			return;
        }
		
		try {
			uDao.insert(new Utente(username, password, nome, cognome, email, Ruolo.user));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private boolean controllaVuoto(String nome,String cognome,String username,String password, String confirmPassword,
			String email,String dataNascita) {
		if(nome.isBlank() || cognome.isBlank() || username.isBlank() || password.isBlank() || email.isBlank() || dataNascita.isBlank())
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
