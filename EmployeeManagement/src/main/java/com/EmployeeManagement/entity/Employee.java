package com.EmployeeManagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long employeeId;
	
	@Column(name = "name")
	private String employeeName;
	
	@Column(name = "dept")
	private String dept;
	
	@Column(name = "designation")
	private String designation;
	
	@Column(name = "salary")
	private Double salary;
	
	@Column(name = "manager_email")
	private String managerEmail;

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", dept=" + dept
				+ ", designation=" + designation + ", salary=" + salary + ", managerEmail=" + managerEmail + "]";
	}
	
	

}
