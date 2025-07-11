package org.elis.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;

import org.elis.model.ElementoOrdine;


/**
 * Servlet implementation class CarrelloServlet
 */
@WebServlet("/CarrelloServlet")
public class CarrelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");

		    String jsonCarrello = request.getParameter("carrello");

		    if (jsonCarrello == null || jsonCarrello.isEmpty()) {
		        System.out.println("⚠️ carrello è null o vuoto!");
		        response.getWriter().write("Carrello assente!");
		        return;
		    }

		    System.out.println("✅ JSON ricevuto: " + jsonCarrello);

		    Gson gson = new Gson();
		    Type listType = new TypeToken<List<ElementoOrdine>>(){}.getType();
		    List<ElementoOrdine> carrello = gson.fromJson(jsonCarrello, listType);

		    // Evita NullPointer se deserializzazione fallisce
		    if (carrello == null) {
		        System.out.println("❌ Deserializzazione fallita, carrello nullo!");
		        response.getWriter().write("Deserializzazione fallita!");
		        return;
		    }

		    for (ElementoOrdine p : carrello) {
		        System.out.println("Portata: " + p.getNome() + ", Quantità: " + p.getQuantita() + ", Prezzo: " + p.getPrezzo());
		    }
		    
	}

}
