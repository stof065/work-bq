package com.own.bq.repository.config;

import java.util.List;

public interface GenericDao<T,PK> {
	
	List<T> findAll() ; 
	
	T findById(PK id);
	
	T save(T o);
	
	void remove(T o) ;

}
