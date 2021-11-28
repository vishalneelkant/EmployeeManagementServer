package com.EmployeeManagement.service;

import java.util.List;

import com.EmployeeManagement.dto.EmployeeDTO;
import com.EmployeeManagement.entity.Employee;



public interface EmployeeService {
	
	public String createEmployee(EmployeeDTO emp);
	
	public Employee getEmployee(Long empId);
	
	public String deleteEmployee(Long empId);
	
	public List<Employee> getAllEmployee();
	
	public EmployeeDTO updateEmployee(Long empId, EmployeeDTO empDTO);
	
	public List<Employee> employeeByManager(String managerEmail) throws Exception;
}
