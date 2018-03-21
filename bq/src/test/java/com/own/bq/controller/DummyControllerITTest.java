package com.own.bq.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.own.bq.controller.config.AbstractControllerIntegrationTest;
import com.own.bq.dto.DummyDto;

public class DummyControllerITTest extends AbstractControllerIntegrationTest {

	private static final Logger LOG = LoggerFactory.getLogger(DummyControllerITTest.class);

	DummyDto dd;

	@BeforeMethod
	public void init() {

		LOG.info("------------------before methode of test : {} ----------------------",
				DummyControllerITTest.class.getSimpleName());

	}

	@Test
	public void findAllDummies() throws Exception {
		mockMvc.perform(get("/dummies")).andExpect(status().isOk())
				.andExpect(content().json(mapper.writeValueAsString(Collections.singletonList(dd))));
	}

}
