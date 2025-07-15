package org.elis.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import org.elis.dao.CategoriaDao;
import org.elis.dao.DaoFactory;
import org.elis.model.Categoria;

@WebServlet("/LogicaAggiungiCategoria")
public class LogicaAggiungiCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LogicaAggiungiCategoria() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoriaDao cdao = DaoFactory.getDaoFactory().getCategoriaDao();
	

		String nome = request.getParameter("nomeCat");
		Long idRist = Long.parseLong(request.getParameter("idRist"));
		Categoria c = new Categoria(null, nome, idRist);
		
		try {
			cdao.insert(c);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect(request.getContextPath() + "/AggiungiPortataServlet");
	}

}
