package com.own.bq.service;

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
		dummy = new Dummy();
		dummy.setName("test name");
		dummy = dummyRepository.save(dummy);
		dummyDto = new DummyDto(dummy);

	}

	@Test
	public void findAllDummyDto() {
		Assertions.assertThat(dummyService.findAllDummyDto().size())
		.isEqualTo(1);
	}

	
}
