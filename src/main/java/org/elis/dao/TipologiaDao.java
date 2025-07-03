package org.elis.dao;

import org.elis.model.Tipologia;

public interface TipologiaDao extends GeneralDao<Tipologia> {
	public Tipologia findTipologiaByNome(String nome) throws Exception;
	
}
