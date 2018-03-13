package com.own.bq.dto;

import org.bq.model.Dummy;
import org.hibernate.validator.constraints.NotBlank;

public class DummyDto {

	private Long id;

	
	@NotBlank(message="le nom ne devrait pas etre vide")
	private String name;

	public DummyDto(Dummy dummy) {
		this.id = dummy.getId();
		this.name = dummy.getName();
	}
	
	public DummyDto() {}

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
