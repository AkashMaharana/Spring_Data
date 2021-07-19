package com.example.springdata;

import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.entities.Customer;
import com.example.entities.PhoneNumber;
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

	/*
	 * @Test public void createCustomer() { Customer customer = new Customer();
	 * customer.setName("Akash Maharana"); PhoneNumber number1 = new PhoneNumber();
	 * number1.setNumber("839028006"); number1.setType("Postpaid"); PhoneNumber
	 * number2 = new PhoneNumber(); number2.setNumber("859809129");
	 * number2.setType("Prepaid"); customer.addPhoneNumber(number1);
	 * customer.addPhoneNumber(number2); customerRepository.save(customer); }
	 */
	
	@Test
	public void getCustomerWithId() {
		System.out.println("-----------------------------getCustomerWithId------------------------------");
		Optional<Customer> customer = customerRepository.findById(22L);
		System.out.println(customer.get().getName());
		Set<PhoneNumber> numbers=customer.get().getNumbers();
		numbers.stream().forEach(number->System.out.println(number.getNumber()+":"+number.getType()));
	}
	
	@Test
	public void updateCustomerWithId() {
		System.out.println("-----------------------------updateCustomerWithId------------------------------");
		Optional<Customer> customer = customerRepository.findById(22L);
		customer.get().setName("Swati Maharana");
		Set<PhoneNumber> numbers=customer.get().getNumbers();
		numbers.forEach(number->number.setType("Postpaid"));
		customerRepository.save(customer.get());
	}
	
	@Test
	public void deleteCustomerWithId() {
		System.out.println("-----------------------------deleteCustomerWithId------------------------------");
		customerRepository.deleteById(22L);
	}

}
