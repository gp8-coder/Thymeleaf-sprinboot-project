package com.luv2code.springboot.cruddemo.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	//add a method to sort by last name
	//public List<Employee> findAllByOrderByLast_nameAsc();
	
	//search by name
	public List<Employee> findByFirstNameContainsOrLastNameContainsAllIgnoreCase(String name, String lName);
}
