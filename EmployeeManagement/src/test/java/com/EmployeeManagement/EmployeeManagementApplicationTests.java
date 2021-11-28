package com.EmployeeManagement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.EmployeeManagement.entity.Employee;
import com.EmployeeManagement.repository.EmployeeRepository;
import com.EmployeeManagement.service.serviceImpl.EmployeeServiceImpl;

@SpringBootTest
class EmployeeManagementApplicationTests {

	@Autowired
	private EmployeeServiceImpl employeeService;
	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	
	@Test
	public void test1() {
//		Employee emp = new Employee();
//		emp.setDept("IVS");
//		emp.setDesignation("Sastiu Job");
//		emp.setEmployeeName("Vishal");
//		emp.setSalary(100.0);
//		
//		//String ser = employeeService.createEmployee(emp);
//		Assertions.assertEquals("added Vishal with id 20", ser);	
	}

}
