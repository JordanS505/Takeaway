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
import org.elis.model.Ordine;
import org.elis.model.Utente;

/**
 * Servlet implementation class ProfiloUtenteServlet
 */
@WebServlet("/ProfiloUtenteServlet")
public class ProfiloUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		OrdineDao oDao = DaoFactory.getDaoFactory().getOrdineDao();
		Utente u = (Utente)session.getAttribute("UtenteLoggato");
		try {
			List<Long> idOrdini = oDao.findAllIdOrdinebyID(u.getIdUtente());
			List<Ordine> ordini = new ArrayList<>();
			for(Long id : idOrdini) {
				Ordine ordine = oDao.selectById(id);
				ordini.add(ordine);
			}
			request.setAttribute("Ordini", ordini);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/WEB-INF/private-jsp/profilo-utente.jsp").forward(request, response);
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
