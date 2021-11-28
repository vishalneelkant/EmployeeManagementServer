package com.EmployeeManagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.EmployeeManagement.entity.Manager;

@Repository
public interface ManagerRepository extends CrudRepository<Manager, String> {
	Manager findBymanagerEmail(String managerEmail);
}
