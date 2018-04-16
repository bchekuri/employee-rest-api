package com.bc.rest;



import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bc.model.Employee;
import com.bc.service.EmployeeService;

@CrossOrigin
@RestController
@RequestMapping(value = "/system/enterprise", consumes = { MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE }, 
		produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
public class EmployeeRestController {

	
	public static final Logger logger = LoggerFactory.getLogger(EmployeeRestController.class);
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@CrossOrigin
	@RequestMapping(value = { "/employee" }, method = RequestMethod.PUT, consumes = { MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE }, 
						produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> createEmployee(@RequestHeader(value = "User-Id") String userId, 
			@RequestHeader(value = "Accept") String accept, @RequestBody(required = true) Employee employee) {
		if(employeeService.createEmployee(employee)) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@CrossOrigin
	@RequestMapping(value = { "/employee" }, method = RequestMethod.GET, consumes = { MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE }, 
						produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> getAllEmployees(@RequestHeader(value = "User-Id") String userId, 
			@RequestHeader(value = "Accept") String accept) {
		return new ResponseEntity<List<Employee>>(employeeService.getAllEmployees(), HttpStatus.OK);
	}
	
}
