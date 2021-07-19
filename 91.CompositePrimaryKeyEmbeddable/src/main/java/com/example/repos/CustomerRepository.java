package com.example.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Customer;
import com.example.entities.CustomerId;

/*	CREATE TABLE customer (
	id int NOT NULL ,
	email varchar(255) NOT NULL,
	name varchar(255) NOT NULL,
	PRIMARY KEY (id,email));
*/

public interface CustomerRepository extends JpaRepository<Customer, CustomerId> {

}
