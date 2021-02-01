package com.luv2code.springboot.cruddemo.controller;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.entity.Employeeskill;
import com.luv2code.springboot.cruddemo.entity.Skill;
import com.luv2code.springboot.cruddemo.service.EmployeeSkillService;
import com.luv2code.springboot.cruddemo.service.EmplyeeService;

@Controller
@RequestMapping("/employeedetail")
public class EmployeeDetailController {


	@Autowired
	private EmplyeeService theemp;
	
	@Autowired
	private EmployeeSkillService skillservice;
	
	@GetMapping("/insert-skill")
	public String insertSkill(@RequestParam("employeeId") int id,Map<String, Object> map) {
		
			Employee emp=theemp.findById(id);
			map.put("skill",new Employeeskill());
			map.put("types",(Arrays.asList(Skill.values())));
			map.put("employees",emp);
			
			return "skill-insert";
		
	}
	
	@GetMapping("/showEmployee")
	public String update(@RequestParam("employeeId") int id,Model model) {
		model.addAttribute("employee",theemp.findById(id));
		return "employee-detail";
	}
	
	//alternate way using spring auto binding mechanism
	@PostMapping("/insert-skill")
	public String saveSkill(@RequestParam("employeeId") int id,Map<String, Object> map, Employeeskill skill) throws SQLException {
		Employee emp = theemp.findById(id);
		skill.setEmp(emp);
		skillservice.save(skill);
		map.put("employee",theemp.findById(id));
		return "employee-detail";
	}
	
}
