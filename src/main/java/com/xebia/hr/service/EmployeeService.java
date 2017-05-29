package com.xebia.hr.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xebia.hr.entity.Course;
import com.xebia.hr.entity.Employee;
import com.xebia.hr.exceptions.NotFoundException;
import com.xebia.hr.repository.EmployeeRepository;

/**
 * Created by anirudh on 20/07/15.
 */
@Service
@Transactional
public class EmployeeService {
	
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Autowired
    private CourseService courseService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Employee createEmployee(Employee employee) {
    	employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        return employeeRepository.save(employee);
    }

    public Employee findByEmpId(String empId) throws NotFoundException {
    	Employee employee = employeeRepository.findByEmpId(empId);
    	if(Objects.isNull(employee)){
			throw new NotFoundException("Invalid Employee: "+ empId);
		}
    	return employee;
    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public List<Employee> findByCourseId(long courseId) throws NotFoundException {
        Course course = courseService.findOne(courseId);
        return employeeRepository.findByCourses(course);
    }
    
    public void save(List<Employee> employees) {
    	employeeRepository.save(employees);
	}
    
    public long findAutoGenEmpId(String empId){
    	Employee employee = employeeRepository.findByEmpId(empId);
    	return employee.getId();
    }
}
