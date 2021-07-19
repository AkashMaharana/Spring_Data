package com.example.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.entities.License;

/*	create table person(
	id int PRIMARY KEY AUTO_INCREMENT,
	first_name varchar(20),
	last_name varchar(20),
	age int);
	
	create table license(
	id int PRIMARY KEY AUTO_INCREMENT,
	type varchar(20),
	valid_from date,
	valid_to date,
	person_id int,
	FOREIGN KEY (person_id)
	REFERENCES person(id));
*/

public interface LicenseRepository extends CrudRepository<License, Integer> {

}
