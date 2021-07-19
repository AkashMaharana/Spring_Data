package com.example.springdata;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.example.entities.Programmer;
import com.example.entities.Project;
import com.example.repos.ProgrammerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableJpaRepositories(basePackages = "com.example.repos")
@EntityScan(basePackages = "com.example.entities")
class ApplicationTests {
	
	@Autowired
	private ProgrammerRepository programmerRepository;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void createProgrammerAndAssignProject() {
		Set<Project> projects=new HashSet<>();
		Project project1=new Project();
		project1.setName("T-Mobile");
		projects.add(project1);
		Project project2=new Project();
		project2.setName("Morgan Stanley");
		projects.add(project2);
		Programmer programmer=new Programmer();
		programmer.setName("Akash Maharana");
		programmer.setProjectList(projects);
		programmer.setSal(78000);
		programmerRepository.save(programmer);
 	}
	
	@Test
	@Transactional
	public void getProgrammerAndProject() {
		Optional<Programmer> programmer = programmerRepository.findById(25);
		System.out.println(programmer.get());
		programmer.get().getProjectList().forEach(System.out::println);
	}
	

}
