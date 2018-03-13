package com.own.bq.controller.config.exception;

import org.joda.time.DateTime;

public class ExceptionMessage {

	private String message;

	private DateTime date = new DateTime();
	
	private String path ;
	
	private ExceptionType exceptionType ;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public DateTime getDate() {
		return date;
	}

	public void setDate(DateTime date) {
		this.date = date;
	}
	
	

	public ExceptionType getExceptionType() {
		return exceptionType;
	}

	public void setExceptionType(ExceptionType exceptionType) {
		this.exceptionType = exceptionType;
	}



	public  static class ExceptionMessageBuilder {

		private String message;
		private String path;
		private ExceptionType exceptionType ;
		
		
		public  ExceptionMessageBuilder exceptionType(ExceptionType exceptionType) {
			this.exceptionType = exceptionType ;
			return this;
		}
		
		
		
		
		public  ExceptionMessageBuilder message(String message) {
			this.message = message ;
			return this;
		}
		
		public  ExceptionMessageBuilder path(String path) {
			this.path = path ;
			return this;
		}

		public  ExceptionMessage build() {
			ExceptionMessage exceptionMessage = new ExceptionMessage();
			exceptionMessage.setMessage(message);
			exceptionMessage.setPath(path);
			exceptionMessage.setExceptionType(exceptionType);
			return exceptionMessage;
		}

	}

}
