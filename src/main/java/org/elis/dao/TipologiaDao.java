package org.elis.dao;

import java.util.List;

import org.elis.model.Tipologia;

public interface TipologiaDao extends GeneralDao<Tipologia> {
	
	public Tipologia findTipologiaByNome(String nome) throws Exception;
	
    List<Tipologia> findTipologieByRistoratoreId(long idRistoratore) throws Exception;

}