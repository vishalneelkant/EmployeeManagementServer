package com.EmployeeManagement.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.EmployeeManagement.entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	List<Employee> findBymanagerEmail(String managerEmail);
}
