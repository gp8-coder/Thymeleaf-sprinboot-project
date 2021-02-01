package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.cruddemo.DAO.EmployeeDetailRepository;
import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.entity.Employeeskill;

@Service
public class EmployeeSkillService {
	
	@Autowired
	private EmployeeDetailRepository skilldao;
	
	
	public List<Employeeskill> findAll(){
		return skilldao.findAll();
	}
	
	public List<Employeeskill> findByCustomer(Employee emp){
		return skilldao.findByEmp(emp);
	}

	public Boolean save(Employeeskill empskill) {
		try {
			skilldao.save(empskill);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
