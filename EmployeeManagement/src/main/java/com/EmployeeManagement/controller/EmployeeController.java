package com.EmployeeManagement.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EmployeeManagement.dto.EmployeeDTO;
import com.EmployeeManagement.dto.ManagerDTO;
import com.EmployeeManagement.entity.Employee;

import com.EmployeeManagement.service.EmployeeService;


@RestController
@RequestMapping("/employee") 
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private Environment environment;
	
	
	@PostMapping(value = "/createEmployee")
	public String createEmployee(@RequestBody EmployeeDTO empdto) {
		
		System.out.println("In API class " + empdto);
		
		String msg = employeeService.createEmployee(empdto);
		return msg;
	}
	
	@GetMapping(value = "/getEmployee/{empId}")
	public Employee getEmployee(@PathVariable Long empId){
		return employeeService.getEmployee(empId);
	}
	
	@DeleteMapping(value = "/deleteEmployee/{empId}")
	public String deleteEmployee(@PathVariable Long empId) {
		return employeeService.deleteEmployee(empId);
	}
	
	@GetMapping(value = "/getAllEmployee")
	public List<Employee> getAllEmployee(){
		return employeeService.getAllEmployee();
	}
	
	@PutMapping(value = "/updateEmployee/{empId}")
	public EmployeeDTO updateEmployee(@PathVariable Long empId, @RequestBody EmployeeDTO employee) {
		EmployeeDTO emp =  employeeService.updateEmployee(empId, employee);
		return emp;
	}
	
	@GetMapping(value = "/getEmployeeByManager/{managerEmail}")
	public List<Employee> employeeByManager(@PathVariable String managerEmail) throws Exception{
		return employeeService.employeeByManager(managerEmail);
	}

}
