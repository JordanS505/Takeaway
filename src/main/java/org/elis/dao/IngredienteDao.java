package org.elis.dao;

import org.elis.model.Ingrediente;

public interface IngredienteDao extends GeneralDao<Ingrediente> {
	public Ingrediente findIngredienteByNome(String Nome) throws Exception;
}
