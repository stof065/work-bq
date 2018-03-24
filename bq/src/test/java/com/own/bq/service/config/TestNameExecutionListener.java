package com.own.bq.service.config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.support.AbstractTestExecutionListener;

public class TestNameExecutionListener extends AbstractTestExecutionListener {

	private static final Logger LOG = LoggerFactory.getLogger(TestNameExecutionListener.class);
	public static ThreadLocal<TestProperties> utTestProperties = new InheritableThreadLocal<>();

	
	DataSource dataSource;

	@Override
	public void beforeTestClass(TestContext testContext) throws Exception {
		LOG.info("setting test name executing fixture", testContext.getTestClass());
		utTestProperties.set(new TestProperties.TestPropertiesBuilder().aTestName(testContext.getTestClass()).build());
		super.beforeTestClass(testContext);
	}

	@Override
	public void beforeTestMethod(TestContext testContext) throws Exception {
		
		
		this.dataSource=testContext.getApplicationContext().getBean(DataSource.class);

		// default path ;
		String path = "db/fixtures/" + testContext.getTestClass().getSimpleName() + "-fixture.sql";
		if (testContext.getTestMethod().isAnnotationPresent(Fixture.class)) {
			path = testContext.getTestMethod().getAnnotation(Fixture.class).path();
		}
		executeSqlFile(path);

		super.beforeTestMethod(testContext);
	}

	private void executeSqlFile(String path) {
		LOG.info("execute fixture in the specific path : {}", path);

		try (Connection c = dataSource.getConnection()) {

			BufferedReader br = new BufferedReader(
					new FileReader(this.getClass().getClassLoader().getResource(path).getPath()));
			String sqlLine = br.readLine();
			while (sqlLine != null) {
				LOG.debug("start treating line : {}",sqlLine);
				c.createStatement().executeUpdate(sqlLine);
				sqlLine = br.readLine();
			}

		} catch (Exception e) {
			LOG.error("erreur executing fixture : {}", e.getMessage());
			throw new RuntimeException("probleme d execution de fixture");
		}
	}

}
