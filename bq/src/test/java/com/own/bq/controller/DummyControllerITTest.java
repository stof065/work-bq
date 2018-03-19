package com.own.bq.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Collections;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.own.bq.controller.config.AbstractControllerIntegrationTest;
import com.own.bq.dto.DummyDto;

public class DummyControllerITTest extends AbstractControllerIntegrationTest {

	private static final Logger LOG = LoggerFactory.getLogger(DummyControllerITTest.class);

	@Autowired
	DataSource dataSource;
	
	
	
	DummyDto dd;

	@BeforeMethod
	public void init() {

		LOG.info("------------------before methode of test : {} ----------------------",
				DummyControllerITTest.class.getSimpleName());

		dd = new DummyDto();
		dd.setId(1L);
		dd.setName("dummy");

		// insert one dummy

		String sqlFixture = "insert into dummy values (?,?)";
		try (Connection c = dataSource.getConnection()) {
			PreparedStatement statement = (PreparedStatement) c.prepareStatement(sqlFixture);
			statement.setLong(1, dd.getId());
			statement.setString(2, dd.getName());
			statement.executeUpdate();
		} catch (Exception e) {
			LOG.error("------------------error executing fixture ----------------------");
			throw new RuntimeException();

		}

	}

	@Test
	public void findAllDummies() throws Exception {
		mockMvc.perform(get("/dummies")).andExpect(status().isOk())
				.andExpect(content().json(mapper.writeValueAsString(Collections.singletonList(dd))));
	}

}
