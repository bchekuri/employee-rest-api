package com.bc.model;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class EmployeeDataTest {

	@Test
	public void validateEmployeeDateList() {
		assertNotNull(EmployeeData.employeeList);
	}
	
}
