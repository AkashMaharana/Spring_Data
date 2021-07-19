package com.example.springdata;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.example.entities.Student;
import com.example.repos.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableJpaRepositories(basePackages = "com.example.repos")
@EntityScan(basePackages = "com.example.entities")
class ApplicationTests {
	
	@Autowired
	private StudentRepository studentRepository;

	@Test
	void contextLoads() {
	}
	
	/*
	 * @Test public void createStudent() { Student student=new Student();
	 * student.setFirstName("Ram"); student.setLastName("Baskey");
	 * student.setScore(90); studentRepository.save(student);
	 * 
	 * Student student1=new Student(); student1.setFirstName("Harish");
	 * student1.setLastName("Chandra"); student1.setScore(76);
	 * studentRepository.save(student1); }
	 */
	
	@Test
	public void findAllStudent() {
		System.out.println("-------------------------findAllStudent------------------------------");
		List<Student> studentList=studentRepository.findAllStudent();
		studentList.forEach(System.out::println);
	}
	
	@Test
	public void findAllStudentsPartialData() {
		System.out.println("-------------------------findAllStudentsPartialData------------------------------");
		List<Object[]> studentArray=studentRepository.findAllStudentsPartialData();
		studentArray.stream().forEach(objectArray->System.out.println(objectArray[0]+" "+objectArray[1]));
	}
	
	@Test
	public void findAllStudentByFirstName() {
		System.out.println("-------------------------findAllStudentByFirstName------------------------------");
		List<Student> findAllStudentByFirstName=studentRepository.findAllStudentByFirstName("Akash");
		findAllStudentByFirstName.forEach(System.out::println);
	}
	
	@Test
	public void findStudentsForGivenScoreRange() {
		System.out.println("-------------------------findStudentsForGivenScoreRange------------------------------");
		List<Student> findStudentsForGivenScoreRange=studentRepository.findStudentsForGivenScoreRange(60, 80);
		findStudentsForGivenScoreRange.forEach(System.out::println);
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void deleteStudentWithGivenFirstName() {
		System.out.println("-------------------------deleteStudentWithGivenFirstName------------------------------");
		studentRepository.deleteStudentWithGivenFirstName("Akash");
		List<Student> studentList=studentRepository.findAllStudent();
		studentList.forEach(System.out::println);
	}
	
	@Test
	public void findAllStudentWithPaging() {
		System.out.println("-------------------------findAllStudentWithPaging------------------------------");
		Pageable pageable = PageRequest.of(0, 2);
		List<Student> findAllStudentWithPaging=studentRepository.findAllStudentWithPaging(pageable);
		findAllStudentWithPaging.forEach(System.out::println);
	}
	
	@Test
	public void findAllStudentWithPagingAndSorting() {
		System.out.println("-------------------------findAllStudentWithPagingAndSorting------------------------------");
		Pageable pageable = PageRequest.of(0, 2,Direction.DESC,"id");
		List<Student> findAllStudentWithPaging=studentRepository.findAllStudentWithPagingAndSorting(pageable);
		findAllStudentWithPaging.forEach(System.out::println);
	}
	
	@Test
	public void findAllStudentUsingNativeQuery() {
		System.out.println("-------------------------findAllStudentUsingNativeQuery------------------------------");
		List<Student> findAllStudentUsingNativeQuery=studentRepository.findAllStudentUsingNativeQuery();
		findAllStudentUsingNativeQuery.forEach(System.out::println);
	}
	
	@Test
	public void findAllStudentByFirstNameUsingNativeQuery() {
		System.out.println("-------------------------findAllStudentByFirstNameUsingNativeQuery------------------------------");
		List<Student> findAllStudentByFirstNameUsingNativeQuery=studentRepository.findAllStudentByFirstNameUsingNativeQuery("Bikash");
		findAllStudentByFirstNameUsingNativeQuery.forEach(System.out::println);
	}
	

}
