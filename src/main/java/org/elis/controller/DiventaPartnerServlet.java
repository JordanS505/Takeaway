package org.elis.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.util.List;

import org.elis.dao.DaoFactory;
import org.elis.dao.TipologiaDao;
import org.elis.model.Tipologia;

@WebServlet("/DiventaPartnerServlet")
public class DiventaPartnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DiventaPartnerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Carica le tipologie disponibili dal database
            TipologiaDao tipologiaDao = DaoFactory.getDaoFactory().getTipologiaDao();
            List<Tipologia> tipologieDisponibili = tipologiaDao.findAll();
            request.setAttribute("tipologieDisponibili", tipologieDisponibili);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        request.getRequestDispatcher("/public-jsp/registrazioneRistoratore.jsp").forward(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
