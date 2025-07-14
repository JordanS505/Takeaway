package org.elis.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.elis.enumerazioni.Stato;
import org.elis.model.Ordine;

public interface OrdineDao extends GeneralDao<Ordine> {
	Ordine selectByData(LocalDateTime data) throws Exception;

	List<Ordine> findByStato(Stato stato) throws Exception;

	List<Ordine> findByData(LocalDateTime data) throws Exception;

	List<Ordine> findOrdinibyRistoratore(String nomeRist) throws Exception;

	List<Long> findAllIdOrdinebyID(long idUtente) throws Exception;

	List<Long> findAllIdOrdinebyIDRistoratore(long idUtente) throws Exception;
	
	public Long inserisciOrdine(Ordine ordine) throws Exception;
	
	 public void inserisciOrdineElementoOrdine(Long idOrdine,Long idElemento) throws Exception;

	 void updateStatoOrdine(Long idOrdine, Stato stato) throws Exception;
}