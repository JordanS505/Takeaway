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
import org.elis.dao.RecensioneDao;
import org.elis.model.Recensione;

/**
 * Servlet implementation class HomePageUtenteServlet
 */
@WebServlet("/HomePageUtenteServlet")
public class HomePageUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomePageUtenteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if(session.getAttribute("UtenteLoggato")!=null) {
			RecensioneDao recensioneDao = DaoFactory.getDaoFactory().getRecensioneDao();
		    try {
		        List<Recensione> recensioni = recensioneDao.findAll();
		        request.setAttribute("recensioni", recensioni);
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		
		    request.getRequestDispatcher("/WEB-INF/private-jsp/HomepageUtente.jsp").forward(request, response);
		
		}else {
			response.sendRedirect(request.getContextPath() + "/LoginServlet");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
