package com.finna.be.octo.avenger.core.db.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity(name = "PROJECTS")
@SequenceGenerator(name = "PROJECTS_SEQ", initialValue=1, allocationSize=100)
public class DBProject {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROJECTS_SEQ")
	private long id;
	
	@Column(name = "NAME", unique = true)
	private String name;
	
	@OneToMany(mappedBy = "project", cascade=CascadeType.PERSIST)
	List<DBTask> tasks;
	
	public DBProject() {
		tasks = new ArrayList<DBTask>();
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
	
	public List<DBTask> getTasks() {
		return tasks;
	}
	
	public void addTask(DBTask task)
	{
		if (!tasks.contains(task)) {
			tasks.add(task);
			task.setProject(this);
		}
	}
	
}
