package org.bq.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class DummyChild {

	@Id
	@GeneratedValue
	private Long id;

	private String name;
	
	
	@ManyToOne
	@JoinColumn(name="dummy_id")
	private Dummy dummy ;

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

	public Dummy getDummy() {
		return dummy;
	}

	public void setDummy(Dummy dummy) {
		this.dummy = dummy;
	}
	
	

}
