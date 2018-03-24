package com.own.bq.service.config;

public class TestProperties {
	Class<?> testName;

	public Class<?> getTestName() {
		return testName;
	}

	public void setTestName(Class<?> testName) {
		this.testName = testName;
	}

	public static class TestPropertiesBuilder
	{

	private Class<?> testName;

	public TestPropertiesBuilder aTestName(Class<?> cls) {
		this.testName = cls;
		return this;
	}

	public TestProperties build() {
		TestProperties testProperties = new TestProperties();
		testProperties.setTestName(this.testName);
		return testProperties;

	}

}

}