package com.luv2code.springboot.cruddemo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="employeeskill")
public class Employeeskill {
	
	@Id
	@Column(name="skills")
	@Enumerated(EnumType.STRING)
	private Skill skills;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="employee_id")
	private Employee emp;
	
	public Employeeskill() {
		
	}

	public Employeeskill(Skill skills, Employee emp) {
		super();
		this.skills = skills;
		this.emp = emp;
	}

	public Skill getSkills() {
		return skills;
	}

	public void setSkills(Skill skills) {
		this.skills = skills;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	
	
	
	
}
