package org.elis.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import org.elis.dao.DaoFactory;
import org.elis.dao.UtenteDao;
import org.elis.dao.inMemory.JDBCUtenteDao;
import org.elis.enumerazioni.Ruolo;
import org.elis.model.Utente;


@WebServlet("/LogicaLogin")
public class LogicaLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public LogicaLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("Password");
		
		UtenteDao uDao = DaoFactory.getDaoFactory().getUtenteDao();
		
		try {
			if(uDao.login(email, password)) {
				System.out.println("Autenticazione riuscita");
				HttpSession session = request.getSession();
				Utente log = uDao.findUtenteByEmail(email);
				session.setAttribute("UtenteLoggato", log);
				response.sendRedirect(request.getContextPath() + "/HomePageUtenteServlet");
				
			}
			else {
				response.sendRedirect(request.getContextPath() + "/LoginServlet?error=autenticazione fallita");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
