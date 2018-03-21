package com.own.bq.dto;

import org.bq.model.DummyChild;
import org.hibernate.validator.constraints.NotBlank;

public class DummyChildDto {

	private Long id;

	@NotBlank(message = "le nom ne devrait pas etre vide")
	private String name;
	
	public DummyChildDto(DummyChild dd) {
		this.id =  dd.getId();
		this.name= dd.getName();
	}

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
