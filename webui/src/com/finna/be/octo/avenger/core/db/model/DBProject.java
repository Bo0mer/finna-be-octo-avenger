package com.finna.be.octo.avenger.core.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "PROJECTS")
@SequenceGenerator(name = "PROJECTS_SEQ", initialValue=1, allocationSize=1)
public class DBProject {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROJECTS_SEQ")
	private long id;
	
	@Column(name = "NAME", unique = true)
	private String name;

	public DBProject() {
	}
	
	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
