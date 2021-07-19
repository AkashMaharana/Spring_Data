package com.example.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
