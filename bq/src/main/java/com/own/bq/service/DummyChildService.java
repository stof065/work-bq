package com.own.bq.service;

import java.util.List;
import java.util.stream.Collectors;

import org.bq.model.Dummy;
import org.bq.model.DummyChild;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.own.bq.controller.config.exception.ResourceNotFoundException;
import com.own.bq.dto.DummyChildDto;
import com.own.bq.repository.DummyChildRepository;
import com.own.bq.repository.DummyRepository;

@Service
public class DummyChildService {

	private static final Logger LOG = LoggerFactory.getLogger(DummyChildService.class);

	@Autowired
	DummyChildRepository dummyChildRepository;

	@Autowired
	DummyRepository dummyRepository;

	public List<DummyChildDto> findDummyChildsByDummy(Long id) {
		return dummyChildRepository.findDummyChildsByDummy(id).stream().map(DummyChildDto::new)
				.collect(Collectors.toList());
	}

	@Transactional
	public DummyChildDto addDummyChildDummy(Long id, DummyChildDto dummyChild) {

		Dummy dummy = dummyRepository.findById(id);
		if (dummy == null) {
			LOG.error("cannot find resource : dummy with id : {}", id);
			throw new ResourceNotFoundException("cannot find resource : dummy with id :" + id);

		}
		DummyChild dc = new DummyChild();
		dc.setDummy(dummy);
		dc.setName(dummyChild.getName());
		return new DummyChildDto(dummyChildRepository.save(dc));
	}

}
