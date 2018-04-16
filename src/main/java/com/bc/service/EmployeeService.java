package com.bc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.bc.dao.EmployeeDAO;
import com.bc.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Autowired
	MessageSource messageSource;
	
	public boolean createEmployee(Employee employee) {
		if(employee != null && employee.getId() > 0 && !employee.getName().isEmpty()) {
			return employeeDAO.createEmployee(employee);
		}
		return false;
	}
	
	public List<Employee> getAllEmployees() {
		return employeeDAO.getAllEmployees();
	}
	
}
