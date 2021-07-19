package com.example.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

/*	use test;
	create table employee(
	id int PRIMARY KEY,
	name varchar(20)
	);
	
	create table id_gen(
	gen_name varchar(60) PRIMARY KEY,
	gen_val int(20)
	);
*/

@Entity
public class Employee {

	@Id
	@TableGenerator(name = "employee_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val",allocationSize = 100)
	@GeneratedValue(strategy = GenerationType.TABLE,generator = "employee_gen")
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
