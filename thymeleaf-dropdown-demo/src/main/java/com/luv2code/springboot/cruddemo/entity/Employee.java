package com.luv2code.springboot.cruddemo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="employee")
public class Employee {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Size(min=3,message="Too small")
//	@Pattern(regexp="^[a-zA-Z]",message="Only chars")
	@Column(name="first_name")
	private String firstName;
	
	@Size(min=3,message="Too small")
//	@Pattern(regexp="^[a-zA-Z]",message="Only chars")
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;

	
	@OneToMany(mappedBy="emp",cascade={CascadeType.DETACH,
			CascadeType.MERGE,CascadeType.PERSIST,
			CascadeType.REFRESH})
	private List<Employeeskill> detail;
	
	
	public Employee() {
		
	}

	
	public Employee(int id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}


	public Employee(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

	public List<Employeeskill> getDetail() {
		return detail;
	}


	public void setDetail(List<Employeeskill> detail) {
		this.detail = detail;
	}
	
	

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	
	
	
}
