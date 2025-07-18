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

import org.elis.dao.CategoriaDao;
import org.elis.dao.DaoFactory;
import org.elis.dao.PortataDao;
import org.elis.dao.UtenteDao;
import org.elis.model.Categoria;
import org.elis.model.Portata;
import org.elis.model.Utente;

@WebServlet("/AggiungiPortataServlet")
public class AggiungiPortataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("UtenteLoggato")!=null) {
			
			
			Utente u = (Utente) session.getAttribute("UtenteLoggato");
			CategoriaDao cdao = DaoFactory.getDaoFactory().getCategoriaDao();
			PortataDao pdao=DaoFactory.getDaoFactory().getPortataDao();
			UtenteDao udao = DaoFactory.getDaoFactory().getUtenteDao();
			
			
			List<Portata> portate = new ArrayList<>();
			try {
				List<Categoria> categorie = u.getCategorie();
				request.setAttribute("categorie", categorie);			
				List<Long> idCat = new ArrayList<>();
				for(Categoria c: categorie) {
					idCat.add(c.getId());
				}
				portate = pdao.findPortataByCategoria(idCat);
				request.setAttribute("listaPortate", portate);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			request.getRequestDispatcher("/WEB-INF/private-jsp/AggiungiPortata.jsp").forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + "/LoginServlet");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
