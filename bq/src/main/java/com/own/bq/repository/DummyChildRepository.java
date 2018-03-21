package com.own.bq.repository;

import java.util.List;

import org.bq.model.DummyChild;
import org.springframework.stereotype.Repository;

import com.own.bq.repository.config.GenericDaoImpl;


@Repository
public class DummyChildRepository extends GenericDaoImpl<DummyChild, Long> {

	public List<DummyChild> findDummyChildsByDummy(Long id) {

		return executeQuery("select dc from DummyChild dc where (dc.dummy.id = ?1)", new Object[] { id });
	}



	
}
