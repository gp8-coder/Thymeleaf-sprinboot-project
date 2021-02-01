package com.luv2code.springboot.cruddemo.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.entity.Employeeskill;

public interface EmployeeDetailRepository extends JpaRepository<Employeeskill, String> {

	String findBySkills(String skills);
	List<Employeeskill> findByEmp(Employee emp);

	//add a method to sort by last name
//	public List<EmployeeDetail> findAllByOrderByLast_nameAsc();
	
	//search by name
//	public List<Employee> findByFirstNameContainsOrLastNameContainsAllIgnoreCase(String name, String lName);
}
