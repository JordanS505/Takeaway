package org.elis.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.elis.dao.DaoFactory;
import org.elis.dao.PortataDao;
import org.elis.model.Portata;

@WebServlet("/RimuoviPortata")
public class RimuoviPortata extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RimuoviPortata() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("idPortata"));
		PortataDao pdao =DaoFactory.getDaoFactory().getPortataDao();
		
		try {
			Portata p = pdao.selectById(id);
			pdao.delete(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect(request.getContextPath() + "/AggiungiPortataServlet");
	}


}
