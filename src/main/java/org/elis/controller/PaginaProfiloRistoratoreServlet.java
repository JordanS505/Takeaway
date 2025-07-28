package org.elis.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.elis.dao.DaoFactory;
import org.elis.dao.OrdineDao;
import org.elis.dao.UtenteDao;
import org.elis.model.Ordine;
import org.elis.model.Utente;

/**
 * Servlet implementation class PaginaProfiloRistoratoreServlet
 */
@WebServlet("/PaginaProfiloRistoratoreServlet")
public class PaginaProfiloRistoratoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		OrdineDao oDao = DaoFactory.getDaoFactory().getOrdineDao();
		UtenteDao uDao = DaoFactory.getDaoFactory().getUtenteDao();
		Utente u = (Utente)session.getAttribute("UtenteLoggato");
		try {
			List<Long> idOrdini = oDao.findAllIdOrdinebyIDRistoratore(u.getIdUtente());
			List<Ordine> ordini = new ArrayList<>();
			u.setVotoM(uDao.VotoMediobyIdRist(u.getIdUtente()));
			for(Long id : idOrdini) {
				Ordine ordine = oDao.selectById(id);
				ordini.add(ordine);
			}
			request.setAttribute("Ordini", ordini);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/WEB-INF/private-jsp/profiloRistoratore.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
