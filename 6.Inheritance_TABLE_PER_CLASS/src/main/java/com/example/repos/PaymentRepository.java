package com.example.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.entities.Payment;

/*	create table card(
	id int PRIMARY KEY,
	amount decimal(8,3),
	cardnumber varchar(20)
	);

	create table bankcheck(
	id int PRIMARY KEY,
	amount decimal(8,3),
	checknumber varchar(20)
	);
*/

public interface PaymentRepository extends CrudRepository<Payment, Integer> {

}
