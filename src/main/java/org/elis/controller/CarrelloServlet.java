package org.elis.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.elis.dao.DaoFactory;
import org.elis.dao.ElementoOrdineDao;
import org.elis.dao.OrdineDao;
import org.elis.dao.PortataDao;
import org.elis.dao.UtenteDao;
import org.elis.enumerazioni.Stato;
import org.elis.model.ElementoOrdine;
import org.elis.model.Ordine;
import org.elis.model.Portata;
import org.elis.model.Utente;


/**
 * Servlet implementation class CarrelloServlet
 */
@WebServlet("/CarrelloServlet")
public class CarrelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsonCarrello = request.getParameter("carrello");
		System.out.println("✅ Ricevuto: " + jsonCarrello);
		String indirizzo = request.getParameter("ristoranteScelto");
		HttpSession session = request.getSession();
		Utente u = (Utente)session.getAttribute("UtenteLoggato");
		Utente ristorante = null;
		if(u==null) {
			response.sendRedirect(request.getContextPath()+"/LoginServlet");
			return;
		}
		UtenteDao udao = DaoFactory.getDaoFactory().getUtenteDao();
		try {
			ristorante = udao.findRistoranteByIndirizzo(indirizzo);
			System.out.println(ristorante.getIdUtente());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Gson
		Gson gson = new GsonBuilder()
		        .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
		        .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
		        .create();
		Type listType = new TypeToken<List<ElementoOrdine>>() {}.getType();
		List<ElementoOrdine> carrello = gson.fromJson(jsonCarrello, listType);
		
		for(ElementoOrdine i : carrello) {
			System.out.println(i);
			
		}
		PortataDao pDao = DaoFactory.getDaoFactory().getPortataDao();
		OrdineDao oDao = DaoFactory.getDaoFactory().getOrdineDao();
		ElementoOrdineDao EODao= DaoFactory.getDaoFactory().getElementoOrdineDao();
		
		try {
			List<Long> elementoOrdineIds = new ArrayList<>();
			for(ElementoOrdine i : carrello) {
				Portata p =pDao.findPortataByNome(i.getNome());
				i.setPortata(p);
				Long idElementoOrdine = EODao.inserisciElementoOrdine(i);
			    elementoOrdineIds.add(idElementoOrdine);
			}
			
			// Then save the Ordine
			Ordine ordine = new Ordine(LocalDateTime.now(), Stato.RICEVUTO, ristorante, u, carrello);
			Long idOrdine = oDao.inserisciOrdine(ordine);

			// Then associate them
			for(Long idElementoOrdine : elementoOrdineIds) {
			    oDao.inserisciOrdineElementoOrdine(idOrdine, idElementoOrdine);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
