package com.EmployeeManagement.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ManagerDTO {

	private Long managerId;
	private String managerName;
	private String firstName;
	private String lastName;
	private String managerEmail;
	private String password;
	private String dept;
	public ManagerDTO(Long managerId, String managerName, String firstName, String lastName, String managerEmail,
			String password, String dept) {
		super();
		this.managerId = managerId;
		this.managerName = managerName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.managerEmail = managerEmail;
		this.password = password;
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "ManagerDTO [managerId=" + managerId + ", managerName=" + managerName + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", managerEmail=" + managerEmail + ", password=" + password + ", dept="
				+ dept + "]";
	}
	
	
	
}
