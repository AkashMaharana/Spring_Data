package com.example.repos;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.entities.Student;


public interface StudentRepository extends CrudRepository<Student, Long> {
	
	@Query("from Student")
	public List<Student> findAllStudent();
	
	@Query("select st.firstName,st.lastName from Student st")
	public List<Object[]> findAllStudentsPartialData();
	
	@Query("from Student where firstName=:firstName")
	public List<Student> findAllStudentByFirstName(@Param("firstName") String firstName);
	
	@Query("from Student where score>:minimum and score<:maximum")
	public List<Student> findStudentsForGivenScoreRange(@Param("minimum") int minimum, @Param("maximum") int maximum);
	
	@Modifying
	@Query("delete from Student where firstName=:firstName")
	public void deleteStudentWithGivenFirstName(@Param("firstName") String firstName);
	
	@Query("from Student")
	public List<Student> findAllStudentWithPaging(Pageable pageable);
	
	@Query("from Student")
	public List<Student> findAllStudentWithPagingAndSorting(Pageable pageable);
	
	@Query(value="select * from student",nativeQuery = true)
	public List<Student> findAllStudentUsingNativeQuery();
	
	@Query(value="select * from student where fname=:firstName",nativeQuery = true)
	public List<Student> findAllStudentByFirstNameUsingNativeQuery(@Param("firstName") String firstName);

}
