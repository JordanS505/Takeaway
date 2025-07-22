package org.elis.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialBlob;

import org.elis.dao.CategoriaDao;
import org.elis.dao.DaoFactory;
import org.elis.dao.PortataDao;
import org.elis.model.Categoria;
import org.elis.model.Portata;

@WebServlet("/LogicaAggiungiPortata")
@MultipartConfig(maxFileSize = 1024*10*1000, maxRequestSize = 1024*15*1000)
public class LogicaAggiungiPortata extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LogicaAggiungiPortata() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PortataDao pdao = DaoFactory.getDaoFactory().getPortataDao();
		CategoriaDao cdao = DaoFactory.getDaoFactory().getCategoriaDao();
		
		String nome = request.getParameter("nome");
		String desc = request.getParameter("descrizione");
		Double prezzo = Double.parseDouble(request.getParameter("prezzo"));
		Long idCat = Long.parseLong(request.getParameter("sezione"));
		Part file= request.getPart("foto");
		byte[] arrayFile= file.getInputStream().readAllBytes();
		boolean senzaLattosio = request.getParameter("senzaLattosio") != null;
		boolean senzaGlutine = request.getParameter("senzaGlutine") != null;
		Blob b=null;
		
		try {
			b = new SerialBlob(arrayFile);
			Categoria categoria = cdao.selectById(idCat); 
			Portata portata = new Portata(null, nome, b, desc, prezzo, categoria, senzaLattosio, senzaGlutine);
			pdao.insert(portata);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect(request.getContextPath() + "/AggiungiPortataServlet");
	}

}
