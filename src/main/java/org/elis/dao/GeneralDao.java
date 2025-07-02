package org.elis.dao;

import java.util.List;

public interface GeneralDao<T> {
	
	void insert(T entity) throws Exception;
	T selectById(Long id) throws Exception;
	List<T> findAll() throws Exception;
	void delete(T entity) throws Exception;
}
