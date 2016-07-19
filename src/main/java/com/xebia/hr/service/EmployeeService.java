package com.xebia.hr.service;

import com.xebia.hr.entity.Course;
import com.xebia.hr.entity.Employee;
import com.xebia.hr.repository.CourseRepository;
import com.xebia.hr.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by anirudh on 20/07/15.
 */
@Service
@Transactional
public class EmployeeService {
	
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Autowired
    private CourseRepository courseRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Employee createEmployee(Employee employee) {
    	employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        return employeeRepository.save(employee);
    }

    public Employee findByEmpId(String empId) {
        return employeeRepository.findByEmpId(empId);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public List<Employee> findByCourseId(long courseId) {
        Course course = courseRepository.findOne(courseId);
        return employeeRepository.findByCourses(course);
    }
}
