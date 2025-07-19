package org.elis.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import org.elis.model.Utente;

/**
 * Servlet implementation class ConfermOrdineServlet
 */
@WebServlet("/ConfermaOrdineServlet")
public class ConfermaOrdineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utente u = (Utente)session.getAttribute("UtenteLoggato");
		request.getRequestDispatcher("/WEB-INF/private-jsp/ordine-confermato.jsp").forward(request, response);
	}


}
