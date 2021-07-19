package com.example.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;


@Entity
public class Employee {

	@Id
	@GenericGenerator(name="emp_id",strategy="com.example.entities.CustomIDGenerator")
	@GeneratedValue(generator = "emp_id")
	private Long id;
	private String name;

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
