package org.elis.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.elis.dao.DaoFactory;
import org.elis.dao.OrdineDao;
import org.elis.enumerazioni.Stato;


@WebServlet("/AggiornamentoStatoServlet")
public class AggiornamentoStatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AggiornamentoStatoServlet() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrdineDao odao = DaoFactory.getDaoFactory().getOrdineDao();
		Long idOrdine = Long.parseLong(request.getParameter("idOrdine"));
		String stato = request.getParameter("ModificaStato");
		if(stato.equalsIgnoreCase("Rifiutato")) {
			try {
				odao.updateStatoOrdine(idOrdine, Stato.RIFIUTATO);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(stato.equalsIgnoreCase("Confermato")) {
			try {
				odao.updateStatoOrdine(idOrdine, Stato.CONFERMATO);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(stato.equalsIgnoreCase("Annullato")) {
			try {
				odao.updateStatoOrdine(idOrdine, Stato.ANNULLATO);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(stato.equalsIgnoreCase("Ritirato")) {
			try {
				odao.updateStatoOrdine(idOrdine, Stato.RITIRATO);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		response.sendRedirect(request.getContextPath()+"/PaginaProfiloRistoratoreServlet");
	}

}
