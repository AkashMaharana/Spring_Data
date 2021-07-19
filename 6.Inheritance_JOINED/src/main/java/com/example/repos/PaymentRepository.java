package com.example.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.entities.Payment;

/*
	create table payment(
	id int PRIMARY KEY,
	amount decimal(8,3));
	
	create table card(
	id int ,
	cardnumber varchar(20),
	 FOREIGN KEY (id)
	REFERENCES payment(id));
	
	create table bankcheck(
	id int ,
	checknumber varchar(20),
	FOREIGN KEY (id)
	REFERENCES payment(id));
*/

public interface PaymentRepository extends CrudRepository<Payment, Integer> {

}
