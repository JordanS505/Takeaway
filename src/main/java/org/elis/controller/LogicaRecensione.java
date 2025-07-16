package org.elis.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import org.elis.dao.DaoFactory;
import org.elis.dao.RecensioneDao;
import org.elis.model.Recensione;
import org.elis.model.Utente;

/**
 * Servlet implementation class LogicaRecensione
 */
@WebServlet("/LogicaRecensione")
public class LogicaRecensione extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RecensioneDao rDao = DaoFactory.getDaoFactory().getRecensioneDao();
		HttpSession session = request.getSession();
		Utente u = (Utente)session.getAttribute("UtenteLoggato");
		String testo = request.getParameter("Testo");
		Double voto = Double.parseDouble(request.getParameter("stella"));
		Long idOrdine = Long.parseLong(request.getParameter("sezione"));
		Recensione recensione = new Recensione(voto, testo, idOrdine, u.getIdUtente());
		
		try {
			rDao.insert(recensione);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath()+"/ProfiloUtenteServlet");
	}

}
