package com.EmployeeManagement.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Manager {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "manager_id")
	private Long managerId;
	
	@Column(name = "firt_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Id
	@Column(name = "manager_email", length = 64)
	private String managerEmail;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "dept")
	private String dept;

	@Override
	public String toString() {
		return "Manager [managerId=" + managerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", managerEmail=" + managerEmail + ", password=" + password + ", dept=" + dept + "]";
	}
	
	
	
}
