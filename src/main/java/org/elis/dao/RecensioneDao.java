package org.elis.dao;

import java.util.List;

import org.elis.model.Recensione;
import org.elis.model.Utente;

public interface RecensioneDao extends GeneralDao<Recensione> {
	public List<Recensione> findRecensioniByVoto(Double voto) throws Exception;
	public List<Recensione> findRecensioniByUtente(Utente u) throws Exception;
	public List<Recensione> findRecensioniByOrdine() throws Exception;
	
}
