package com.own.bq.dto;

import org.bq.elastic.model.DummyDocument;
import org.hibernate.validator.constraints.NotBlank;

public class DummyDocumentDto {

	private Long id;

	
	@NotBlank(message="le nom ne devrait pas etre vide")
	private String name;

	public DummyDocumentDto(DummyDocument dd) {
		this.id = dd.getId();
		this.name = dd.getName();
	}
	
	public DummyDocumentDto() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
