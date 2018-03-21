package com.own.bq.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.own.bq.dto.DummyChildDto;
import com.own.bq.repository.DummyChildRepository;

@Service
public class DummyChildService {

	@Autowired
	DummyChildRepository dummyChildRepository;

	public List<DummyChildDto> findDummyChildsByDummy(Long id) {
		return dummyChildRepository.findDummyChildsByDummy(id).stream().map(DummyChildDto::new)
				.collect(Collectors.toList());
	}

}
