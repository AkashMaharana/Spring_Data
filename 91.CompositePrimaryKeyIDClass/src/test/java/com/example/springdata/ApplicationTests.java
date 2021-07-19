package com.example.springdata;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.entities.Customer;
import com.example.repos.CustomerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableJpaRepositories(basePackages = "com.example.repos")
@EntityScan(basePackages = "com.example.entities")
class ApplicationTests {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void saveCustomer() {
		Customer customer=new Customer();
		customer.setId(100);
		customer.setName("Akash Maharana");
		customer.setEmail("akash@bt.com");
		customerRepository.save(customer);
	}

}
