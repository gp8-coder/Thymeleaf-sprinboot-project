package com.luv2code.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import com.luv2code.springboot.cruddemo.entity.Employee;

public interface EmplyeeService {

	public List<Employee> findAll();
	public Employee findById(int id);
	public void save(Employee theemp);
	public void deleteById(int id);
	List<Employee> searchBy(String theName);
}
