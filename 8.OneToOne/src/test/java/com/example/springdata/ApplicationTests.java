package com.example.springdata;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.entities.License;
import com.example.entities.Person;
import com.example.repos.LicenseRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableJpaRepositories(basePackages = "com.example.repos")
@EntityScan(basePackages = "com.example.entities")
class ApplicationTests {
	
	@Autowired
	private LicenseRepository licenseRepository;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void createLicenseAndAssign() {
		License license=new License();
		license.setType("Bike");
		license.setValidFrom(new Date());
		license.setValidTo(new Date());
		Person person=new Person();
		person.setFirstName("Akash");
		person.setLastName("Maharana");
		person.setAge(27);
		license.setPerson(person);
		licenseRepository.save(license);
	}

}
