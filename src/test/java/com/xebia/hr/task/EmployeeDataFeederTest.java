package com.xebia.hr.task;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.xebia.hr.DefaultTestAnnotations;
import com.xebia.hr.entity.Employee;
import com.xebia.hr.service.EmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@DefaultTestAnnotations
public class EmployeeDataFeederTest {
	
	@Autowired
	private EmployeeDataFeeder employeeDataFeeder;
	
	@Autowired
	private EmployeeService employeeService;

	@Test
	public void updateEmployees_CheckNoOfRecordsUpdated() {
		employeeDataFeeder.updateEmployees();
		
		List<Employee> employees = employeeService.findAllEmployees();
		assertNotNull(employees);
		assertEquals(9, employees.size());
	}
	
}
