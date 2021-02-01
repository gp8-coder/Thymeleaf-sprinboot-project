package com.luv2code.springboot.cruddemo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.entity.Employeeskill;
import com.luv2code.springboot.cruddemo.service.EmplyeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	private EmplyeeService theEmployee;
	
	@Autowired
	public EmployeeController(EmplyeeService e) {
		theEmployee=e;
	}
	
	
	@GetMapping("/list")
	public String getEmployees(Model model) {
		
		List<Employee> emp=theEmployee.findAll();
		model.addAttribute("employees",emp);
		return "list-employees";
	}
	
	@GetMapping("/showFormForAdd")
	public String showForm(Model model) {
		Employee emp=new Employee();
		model.addAttribute("employees",emp);
		return "employee-form";
	}
	
	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("employees") Employee emp,BindingResult bind) {
		
		if(bind.hasErrors()) {
			return "employee-form";
		}
		else {
		theEmployee.save(emp);
		
		return "redirect:/employee/list";}
	}
	
	@GetMapping("/showFormForUpdate")
	public String update(@RequestParam("employeeId") int id,Model model) {
		Employee emp=theEmployee.findById(id);
		model.addAttribute("employees",emp);
		return "employee-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int id,Model model) {
		theEmployee.deleteById(id);
		return "redirect:/employee/list";
	}
	
	@GetMapping("/search")
	public String delete(@RequestParam("employeeName") String theName,
						 Model theModel) {
		
		List<Employee> theEmployees = theEmployee.searchBy(theName);
		
		// add to the spring model
		theModel.addAttribute("employees", theEmployees);
		
		// send to /employees/list
		return "list-employees";
		
	} 
}
