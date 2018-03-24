package com.own.bq.service;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.bq.model.Dummy;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.own.bq.dto.DummyDto;
import com.own.bq.repository.DummyRepository;
import com.own.bq.service.config.AbstractIntegrationTest;



public class DummyServiceITTest extends AbstractIntegrationTest {

	@Autowired
	DummyService dummyService;

	@Autowired
	DummyRepository dummyRepository;

	Dummy dummy;
	DummyDto dummyDto ;

	@BeforeMethod
	public void init() {
		

	}

	@Test
	public void findAllDummyDto() {
		List<DummyDto> dummies = dummyService.findAllDummyDto();
		Assertions.assertThat(dummies.size())
		.isEqualTo(2);
	}

	
}
