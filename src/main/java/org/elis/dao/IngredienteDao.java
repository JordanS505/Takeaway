package org.elis.dao;

import java.util.List;

import org.elis.model.Ingrediente;

public interface IngredienteDao extends GeneralDao<Ingrediente> {
	Ingrediente findIngredienteByNome(String nome) throws Exception;
    
    List<Ingrediente> findIngredienteBySenzaLattosio(boolean senzaLattosio) throws Exception;
    
    List<Ingrediente> findIngredienteBySenzaGlutine(boolean senzaGlutine) throws Exception;
}
