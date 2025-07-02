package org.elis.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.elis.model.Ordine;

public interface OrdineDao extends GeneralDao<Ordine> {
	public Ordine findOrdineByDataEOra(LocalDateTime data) throws Exception;
	
	public List<Ordine> findOrdineByData(LocalDate data) throws Exception;
}
