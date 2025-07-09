package org.elis.dao;

import java.util.List;

import org.elis.model.Categoria;

public interface CategoriaDao extends GeneralDao<Categoria> {
	
	public Categoria findCategoriaByNome(String nome) throws Exception;
	
	public List<Categoria> findCategorieByIdRistorante(Long id) throws Exception;

	public List<Categoria> findCategorieByIndirizzoRistorante(String indirizzo) throws Exception;
}
