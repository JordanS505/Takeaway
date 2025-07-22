package org.elis.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.elis.dao.DaoFactory;
import org.elis.dao.TipologiaDao;
import org.elis.model.Tipologia;

import java.io.IOException;


@WebServlet("/AggiungiTipologiaServlet")
public class AggiungiTipologiaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nomeTipologia = request.getParameter("nome");
        
        if (nomeTipologia != null && !nomeTipologia.trim().isEmpty()) {
            TipologiaDao tipologiaDao = DaoFactory.getDaoFactory().getTipologiaDao();
            try {
                // Verifica se la tipologia esiste già
                Tipologia esistente = tipologiaDao.findTipologiaByNome(nomeTipologia);
                if (esistente == null) {
                    // Se non esiste, crea una nuova tipologia
                    Tipologia nuova = new Tipologia(nomeTipologia);
                    tipologiaDao.insert(nuova);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        response.setStatus(HttpServletResponse.SC_OK);
    }
}