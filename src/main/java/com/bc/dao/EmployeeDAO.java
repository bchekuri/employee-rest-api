package com.bc.dao;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.bc.model.Employee;
import com.bc.model.EmployeeData;

@Component
public class EmployeeDAO {

	public boolean createEmployee(Employee employee) {
		EmployeeData.employeeList.add(employee);
		return true;
	}
	
	
	public List<Employee> searchEmployee(Employee employee) {
		return EmployeeData.employeeList.stream().filter(e -> employee.getId() == e.getId() || employee.getName().equals(e.getName()))
								.collect(Collectors.toList());
	}
	
	
	public List<Employee> getAllEmployees() {
		return EmployeeData.employeeList;
	}
	
	
	public boolean deleteEmployee(int id) {
		Iterator<Employee> iterator = EmployeeData.employeeList.iterator();
		while (iterator.hasNext()) {
			Employee employee = (Employee) iterator.next();
			if(employee.getId() == id) {
				iterator.remove();
			}
		}
		return true;
	}
	
}

