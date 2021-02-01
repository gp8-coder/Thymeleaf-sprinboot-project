package com.luv2code.springboot.cruddemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.cruddemo.DAO.EmployeeRepository;
import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.entity.Employeeskill;

@Service
public class EmployeeServiceImpl implements EmplyeeService {

	private EmployeeRepository empdao;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theemp) {
		empdao=theemp;
	}
	@Override
	public List<Employee> findAll() {
		return empdao.findAll();
	}

	@Override
	public Employee findById(int id) {
		Optional<Employee> result = empdao.findById(id);
		 Employee theemp = null;
		 
		 if(result.isPresent()) {
			 theemp = result.get();
		 }
		 else {
			 throw new RuntimeException("Did not find employee id : " + id);
			 }
		return theemp;
	}

	@Override
	public void save(Employee theemp) {
		empdao.save(theemp);
	}

	@Override
	public void deleteById(int id) {

		empdao.deleteById(id);
	}
	
	@Override
	public List<Employee> searchBy(String theName) {
		
		List<Employee> results = null;
		
		if (theName != null && (theName.trim().length() > 0)) {
			results = empdao.findByFirstNameContainsOrLastNameContainsAllIgnoreCase(theName, theName);
		}
		else {
			results = findAll();
		}
		
		return results;
	} 

}
