package org.elis.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.elis.dao.CategoriaDao;
import org.elis.dao.DaoFactory;
import org.elis.dao.PortataDao;
import org.elis.dao.UtenteDao;
import org.elis.model.Categoria;
import org.elis.model.Portata;
import org.elis.model.Utente;

/**
 * Servlet implementation class PaginaRistorante
 */
@WebServlet("/PaginaRistorante")
public class PaginaRistorante extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtenteDao udao = DaoFactory.getDaoFactory().getUtenteDao();
		CategoriaDao cdao = DaoFactory.getDaoFactory().getCategoriaDao();
		PortataDao pdao=DaoFactory.getDaoFactory().getPortataDao();
		String indirizzo = request.getParameter("indirizzo");
		
		try {
			Utente u = udao.findRistoranteByIndirizzo(indirizzo);
			List<Categoria> c = cdao.findCategorieByIndirizzoRistorante(indirizzo);
			List<Long> idS = new ArrayList<Long>();
			for(Categoria cat : c) {
				idS.add(cat.getId());
			}
			List<Portata> p = pdao.findPortataByCategoria(idS);
			request.setAttribute("ristoranteScelto", u);
			request.setAttribute("categorie", c);
			request.setAttribute("listaPortate", p);
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
