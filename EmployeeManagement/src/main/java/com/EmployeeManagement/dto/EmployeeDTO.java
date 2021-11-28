package com.EmployeeManagement.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeeDTO {
	
	private Long employeeId;
	private String employeeName;
	private String dept;
	private String designation;
	private Double salary;
	private String managerEmail;
	
	public EmployeeDTO() {
		
	}

	public EmployeeDTO(Long employeeId, String employeeName, String dept, String designation, Double salary,
			String managerEmail) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.dept = dept;
		this.designation = designation;
		this.salary = salary;
		this.managerEmail = managerEmail;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [employeeId=" + employeeId + ", employeeName=" + employeeName + ", dept=" + dept
				+ ", designation=" + designation + ", salary=" + salary + ", managerEmail=" + managerEmail + "]";
	}	
	
	
}
