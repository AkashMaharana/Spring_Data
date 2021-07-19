package com.example.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.entities.Programmer;

/*	create table programmer(
	id int PRIMARY KEY AUTO_INCREMENT,
	name varchar(20),
	salary int
	);
	
	create table project(
	id int PRIMARY KEY AUTO_INCREMENT,
	name varchar(20)
	);
	
	create table programmers_projects(
	programmer_id int,
	project_id int,
	FOREIGN KEY (programmer_id)
	REFERENCES programmer(id),
	FOREIGN KEY (project_id)
	REFERENCES project(id));
*/


public interface ProgrammerRepository extends CrudRepository<Programmer, Integer> {

}
