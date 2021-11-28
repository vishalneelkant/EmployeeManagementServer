package com.EmployeeManagement.service;

import com.EmployeeManagement.dto.ManagerDTO;
import com.EmployeeManagement.exception.EmployeeException;

public interface ManagerService {

	public String createManager(ManagerDTO mdto) throws EmployeeException;
	
	public String  authenticateManager(ManagerDTO mdto)throws Exception;
}
