package com.own.bq.repository.config;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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

	public List<T> executeQuery(String queryString, Object[] objects) {
		TypedQuery<T> query = em.createQuery(queryString, type);
		AtomicInteger i = new AtomicInteger(0);
		Stream.of(objects).forEach(p -> {
			query.setParameter(i.incrementAndGet(), p);
		});
		return query.getResultList();
	}

}
