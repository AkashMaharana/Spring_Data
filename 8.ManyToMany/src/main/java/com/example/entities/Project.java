package com.example.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	@ManyToMany(mappedBy = "projectList")
	private Set<Programmer> programmerList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Programmer> getProgrammerList() {
		return programmerList;
	}

	public void setProgrammerList(Set<Programmer> programmerList) {
		this.programmerList = programmerList;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + "]";
	}

}