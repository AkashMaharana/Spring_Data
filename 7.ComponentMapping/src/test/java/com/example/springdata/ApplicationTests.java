package com.example.springdata;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.entities.Address;
import com.example.entities.Employee;
import com.example.repos.EmployeeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableJpaRepositories(basePackages = "com.example.repos")
@EntityScan(basePackages = "com.example.entities")
class ApplicationTests {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void createEmployeeWithAddress() {
		Employee employee=new Employee();
		employee.setId(1);
		employee.setName("Akash Maharana");
		Address address=new Address();
		address.setCity("Bengaluru");
		address.setCountry("India");
		address.setState("karnataka");
		address.setStreetaddress("Kundanahalli");
		address.setZipcode("560037");
		employee.setAddress(address);
		employeeRepository.save(employee);
	}

}
