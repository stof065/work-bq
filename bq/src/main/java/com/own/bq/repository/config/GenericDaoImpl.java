package com.own.bq.repository.config;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class GenericDaoImpl<T, PK> implements GenericDao<T, PK> {

	@PersistenceContext
	EntityManager em;

	Class<T> type;

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
		type = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public List<T> findAll() {
		return em.createQuery("from " + type.getSimpleName() + " x", type).getResultList();
	}

	@Override
	public T findById(PK id) {

		return em.find(type, id);
	}

	@Override
	public T save(T o) {
		return em.merge(o);
	}
	
	public void remove(T o) {
		em.remove(o);
	}


}
