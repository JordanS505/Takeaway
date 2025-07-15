package org.elis.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import org.elis.dao.DaoFactory;
import org.elis.dao.UtenteDao;
import org.elis.model.Utente;

@WebServlet("/ListaRistorantiServlet")
public class ListaRistorantiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtenteDao uDao = DaoFactory.getDaoFactory().getUtenteDao();
		
		try {
			List<Utente> ristoranti = uDao.findRistoratori(); // solo quelli con ruolo ristoratore
			request.setAttribute("ristoranti", ristoranti);
			request.getRequestDispatcher("/public-jsp/ListaRistoranti.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
