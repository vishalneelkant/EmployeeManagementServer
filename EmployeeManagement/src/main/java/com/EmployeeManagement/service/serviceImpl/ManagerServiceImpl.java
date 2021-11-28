package com.EmployeeManagement.service.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.EmployeeManagement.dto.ManagerDTO;
import com.EmployeeManagement.entity.Manager;
import com.EmployeeManagement.exception.EmployeeException;
import com.EmployeeManagement.repository.EmployeeRepository;
import com.EmployeeManagement.repository.ManagerRepository;
import com.EmployeeManagement.service.ManagerService;

@Service("managerService")
@Transactional
public class ManagerServiceImpl implements ManagerService {
	
	@Autowired
	private EmployeeRepository empRepo;
	
	@Autowired
	private ManagerRepository managerRepo;

	@Override
	public String createManager(ManagerDTO mdto) throws EmployeeException {
		
		if(mdto==null) {
			throw new EmployeeException("provided Manager is null");
		}
		
		Manager manager = new Manager();
		manager.setDept(mdto.getDept());
		manager.setManagerEmail(mdto.getManagerEmail().toLowerCase());
		manager.setFirstName(mdto.getFirstName());
		manager.setLastName(mdto.getLastName());
		manager.setPassword(mdto.getPassword());
		
		Manager managerFromRepo = managerRepo.save(manager);
		if(managerFromRepo==null) {
			throw new EmployeeException("wouldn't save Manager in database");
		}
		 return "manager save successfully with email " + managerFromRepo.getManagerEmail();
	}

	@Override
	public String authenticateManager(ManagerDTO mdto) throws Exception {
		String email = mdto.getManagerEmail().toLowerCase();
		System.out.println("Email " + email);
		String password = mdto.getPassword();
		
		Optional<Manager> optional = managerRepo.findById(email);
		if(optional.isEmpty()) {
			throw new Exception("Please Provide valid login credentials");
		}
		Manager manager = optional.get();
		
		if(manager.getManagerEmail().equals(email) && manager.getPassword().equals(password)) {
			return "Login Successfull " + manager.getFirstName();
		}
		else {
			throw new Exception("Credentials is not valid"); 
		}
		
	}
	
	

}
