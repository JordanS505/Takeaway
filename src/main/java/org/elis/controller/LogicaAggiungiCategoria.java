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
import org.elis.dao.UtenteDao;
import org.elis.model.Portata;
import org.elis.model.Categoria;
import org.elis.model.Utente;

@WebServlet("/LogicaAggiungiCategoria")
public class LogicaAggiungiCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LogicaAggiungiCategoria() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("UtenteLoggato")!=null) {
			CategoriaDao cdao = DaoFactory.getDaoFactory().getCategoriaDao();
			Utente u = (Utente)session.getAttribute("UtenteLoggato");
			List<Portata> portate = new ArrayList<>();
			String nome = request.getParameter("nomeCat");
			try {
				cdao.insert(new Categoria(null, nome, u, portate));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		response.sendRedirect(request.getContextPath() + "/AggiungiPortataServlet");
	}

}
