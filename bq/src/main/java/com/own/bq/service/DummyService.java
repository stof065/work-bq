package com.own.bq.service;

import java.util.List;
import java.util.stream.Collectors;

import org.bq.model.Dummy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.own.bq.controller.config.exception.ResourceNotFoundException;
import com.own.bq.dto.DummyDto;
import com.own.bq.repository.DummyRepository;

@Service
public class DummyService {
	
	private static final Logger LOG = LoggerFactory.getLogger(DummyService.class);

	@Autowired
	DummyRepository dummyRepository;

	@Transactional
	public List<DummyDto> findAllDummyDto() {
		return dummyRepository.findAll().stream().map(DummyDto::new).collect(Collectors.toList());
	}

	public DummyDto findDummy(Long id) {
		return new DummyDto(dummyRepository.findById(id));
	}

	@Transactional
	public DummyDto save(DummyDto dummy) {
		Dummy d = new Dummy();
		d.setId(dummy.getId());
		d.setName(dummy.getName());
		return new DummyDto(dummyRepository.save(d));
	}

	
	@Transactional
	public void removeDummy(Long id) {
		
		Dummy dummy = dummyRepository.findById(id);
		if(dummy == null) {
			LOG.error("dummy with id : {} not found",id);
			throw new ResourceNotFoundException("dummy with id :" + id + " not found") ;
		}
		dummyRepository.remove(dummy) ;
	}

}
