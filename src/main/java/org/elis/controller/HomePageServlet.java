package org.elis.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import org.elis.dao.DaoFactory;
import org.elis.dao.RecensioneDao;
import org.elis.dao.jpa.JPARecensioneDao;
import org.elis.model.Recensione;

@WebServlet("/HomePageServlet")
public class HomePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public HomePageServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RecensioneDao recensioneDao = DaoFactory.getDaoFactory().getRecensioneDao();
	    try {
	        List<Recensione> recensioni = recensioneDao.findAll();
	        request.setAttribute("recensioni", recensioni);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    request.getRequestDispatcher("/public-jsp/Homepage.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
