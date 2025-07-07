package org.elis.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.elis.dao.DaoFactory;
import org.elis.dao.UtenteDao;
import org.elis.model.Utente;

/**
 * Servlet implementation class PaginaRistorante
 */
@WebServlet("/PaginaRistorante")
public class PaginaRistorante extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtenteDao udao = DaoFactory.getDaoFactory().getUtenteDao();
		try {
			Utente u = udao.findRistoranteByIndirizzo("Via Milano 2");
			System.out.println(u);
			request.setAttribute("ristoranteScelto", u);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("/public-jsp/PagSingoloRistorante.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
