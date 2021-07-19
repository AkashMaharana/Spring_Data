package com.example.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.entities.Payment;

/*	create table payment(
	id int PRIMARY KEY,
	pmode varchar(2),
	amount decimal(8,3) ,
	cardnumber varchar(20),
	checknumber varchar(20));
*/

public interface PaymentRepository extends CrudRepository<Payment, Integer> {

}
