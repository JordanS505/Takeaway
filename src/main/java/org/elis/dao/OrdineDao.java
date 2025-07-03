package org.elis.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.elis.enumerazioni.Stato;
import org.elis.model.Ordine;

public interface OrdineDao extends GeneralDao<Ordine> {
	Ordine selectByData(LocalDateTime data) throws Exception;

	List<Ordine> findByStato(Stato stato) throws Exception;

	List<Ordine> findByData(LocalDateTime data) throws Exception;
}