package com.EmployeeManagement.service.serviceImpl;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.EmployeeManagement.dto.EmployeeDTO;
import com.EmployeeManagement.entity.Employee;
import com.EmployeeManagement.entity.Manager;
import com.EmployeeManagement.repository.EmployeeRepository;
import com.EmployeeManagement.service.EmployeeService;

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepo;

	@Override
	public String createEmployee(EmployeeDTO empDTO) {
		
		System.out.println(empDTO);
		
		Employee emp = new Employee();
		
		emp.setDept(empDTO.getDept());
		emp.setDesignation(empDTO.getDesignation());
		emp.setEmployeeName(empDTO.getEmployeeName());
		emp.setSalary(empDTO.getSalary());
		emp.setManagerEmail(empDTO.getManagerEmail().toLowerCase());
		
		Employee e = employeeRepo.save(emp);
		return "added " + e.getEmployeeName() + " " + "with id" + " " + e.getEmployeeId(); 
	}

	@Override
	public Employee getEmployee(Long empId) {
		
		Optional<Employee> optional = employeeRepo.findById(empId);
		return optional.get();
	}

	@Override
	public String deleteEmployee(Long empId) {
		Optional<Employee> emp = employeeRepo.findById(empId);
		if(emp.isPresent()) {
			employeeRepo.deleteById(empId);
			return "Deleted " + empId;
		}
		else {
			return "Employee Not found";
		}
	} 
	
	@Override
	public List<Employee> getAllEmployee(){
		List<Employee> empList = new ArrayList<>();
		Iterable<Employee> empIterator = employeeRepo.findAll();
		
		for(Employee e : empIterator) {
			Employee emp = new Employee();
			emp.setDept(e.getDept());
			emp.setDesignation(e.getDesignation());
			emp.setEmployeeId(e.getEmployeeId());
			emp.setEmployeeName(e.getEmployeeName());
			emp.setSalary(e.getSalary());
			emp.setManagerEmail(e.getManagerEmail());
			
			empList.add(emp);
		}
		
		return empList;
		
	}
	
	@Override
	public EmployeeDTO updateEmployee(Long empId, EmployeeDTO empDTO) {
		
		Employee empToSave = new Employee();
		
		Optional<Employee> optionalEmp =  employeeRepo.findById(empId);
		Employee empFromRepo = optionalEmp.get();
		
		if(empDTO.getDept()==null || empDTO.getDept().isEmpty()) {
			empToSave.setDept(empFromRepo.getDept());
		}
		else {
			empToSave.setDept(empDTO.getDept());
		}
		
		if(empDTO.getDesignation()==null|| empDTO.getDesignation().isEmpty()) {
			empToSave.setDesignation(empFromRepo.getDesignation());
		}
		else {
			empToSave.setDesignation(empDTO.getDesignation());
		}
		
		if(empDTO.getEmployeeName()==null || empDTO.getEmployeeName().isEmpty()) {
			empToSave.setEmployeeName(empFromRepo.getEmployeeName());
		}
		else {
			empToSave.setEmployeeName(empDTO.getEmployeeName());
		}
		
		if(empDTO.getSalary()==null) {
			empToSave.setSalary(empFromRepo.getSalary());
		}
		else {
			empToSave.setSalary(empDTO.getSalary());
		}
		if(empDTO.getManagerEmail()==null || empDTO.getManagerEmail().isBlank()) {
			empToSave.setEmployeeName(empFromRepo.getEmployeeName());
		}
		else {
			empToSave.setManagerEmail(empDTO.getManagerEmail());
		}
		
		empToSave.setEmployeeId(empFromRepo.getEmployeeId());
		
		employeeRepo.save(empToSave);
		return empDTO;
	}

	@Override
	public List<Employee> employeeByManager(String managerEmail) throws Exception {
		List<Employee> employeeList = null;
	    employeeList = employeeRepo.findBymanagerEmail(managerEmail);
		if(employeeList == null) {
			throw new Exception("No employee Available");
		}
		return employeeList;
	}
	
	
}
