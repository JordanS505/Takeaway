package org.elis.dao;

import org.elis.model.ElementoOrdine;

public interface ElementoOrdineDao extends GeneralDao<ElementoOrdine> {
    ElementoOrdine findElementoOrdineByNome(String nome) throws Exception;
}