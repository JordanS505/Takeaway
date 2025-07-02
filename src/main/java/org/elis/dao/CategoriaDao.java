package org.elis.dao;

import org.elis.model.Categoria;

public interface CategoriaDao extends GeneralDao<Categoria> {
	public Categoria findCategoriaByNome(String nome) throws Exception;
}
