package org.elis.dao;

import java.util.List;

import org.elis.model.Portata;

public interface PortataDao extends GeneralDao<Portata> {
	public Portata findPortataByNome(String nome) throws Exception;
	public List<Portata> findPortataByCategoria(List<Long> id) throws Exception;
	public List<Portata> findPortateByNomeRistoranteOrdine(String nomeRistorante, long idOrdine) throws Exception;
	void delete(Long id) throws Exception;
}
