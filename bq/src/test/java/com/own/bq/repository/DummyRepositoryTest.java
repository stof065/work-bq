package com.own.bq.repository;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.Test;

public class DummyRepositoryTest  {
	
	@Mock
	DummyRepository dummyRepository;

	@Test
	public void surefireTest() {
		MockitoAnnotations.initMocks(this);
		System.out.println(dummyRepository);
	}

}
