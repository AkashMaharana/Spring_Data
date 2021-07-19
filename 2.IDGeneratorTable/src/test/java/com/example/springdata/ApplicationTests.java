package com.example.springdata;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.entities.Employee;
import com.example.repos.EmployeeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableJpaRepositories(basePackages = "com.example.repos")
@EntityScan(basePackages = "com.example.entities")
class ApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Test
	public void createEmployee() {
		Employee employee=new Employee();
		employee.setName("Akash");
		employeeRepository.save(employee);
	}

}
