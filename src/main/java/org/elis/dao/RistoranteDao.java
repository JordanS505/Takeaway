package org.elis.dao;

import org.elis.model.Ristorante;

public interface RistoranteDao extends GeneralDao<Ristorante> {
	public Ristorante findRistoranteByNome(String nome) throws Exception;
	
	public Ristorante findRistoranteByIndirizzo(String indirizzo) throws Exception;
}
