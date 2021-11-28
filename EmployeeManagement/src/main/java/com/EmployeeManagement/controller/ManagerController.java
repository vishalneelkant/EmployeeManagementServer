package com.EmployeeManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EmployeeManagement.dto.ManagerDTO;
import com.EmployeeManagement.entity.Manager;
import com.EmployeeManagement.exception.EmployeeException;
import com.EmployeeManagement.service.ManagerService;

@RestController
@RequestMapping("/manager") 
public class ManagerController {

	@Autowired
	private ManagerService managerService;
	
	@Autowired
	private Environment environment;
	
	@PostMapping(value = "/createManager")
	public String createManager(@RequestBody ManagerDTO mdto) throws EmployeeException {
		return managerService.createManager(mdto);
		
	}
	
	@PostMapping(value = "/authenticate")
	public String authenticate(@RequestBody ManagerDTO mdto) throws Exception {
		//System.out.println("In authenticate "+ mdto);
		return managerService.authenticateManager(mdto);
	}
}
