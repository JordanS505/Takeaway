package org.elis.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.elis.dao.CategoriaDao;
import org.elis.dao.DaoFactory;
import org.elis.dao.PortataDao;
import org.elis.model.Categoria;
import org.elis.model.Portata;

@WebServlet("/RimuoviCategoria")
public class RimuoviCategoria extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long idCategoria = Long.parseLong(request.getParameter("idCategoria"));
        
        CategoriaDao cdao = DaoFactory.getDaoFactory().getCategoriaDao();
        PortataDao pdao = DaoFactory.getDaoFactory().getPortataDao();
        
        try {
            Categoria categoria = cdao.selectById(idCategoria);
            
            // Prima elimina tutte le portate associate
            if(categoria.getPortate() != null && !categoria.getPortate().isEmpty()) {
                for(Portata p : categoria.getPortate()) {
                    pdao.delete(p);
                }
            }
            
            // Poi elimina la categoria
            cdao.delete(categoria);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        response.sendRedirect(request.getContextPath() + "/AggiungiPortataServlet");
    }
}
