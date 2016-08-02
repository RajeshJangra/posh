package com.xebia.hr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xebia.hr.entity.Employee;
import com.xebia.hr.exceptions.NotFoundException;
import com.xebia.hr.service.CourseService;
import com.xebia.hr.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    
    @Autowired
    private CourseService courseService;

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize(value="hasRole('admin')")
    public Employee createUser(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @RequestMapping(value = "{empId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize(value="hasRole('admin')")
    public ResponseEntity<?> findUserbyId(@PathVariable String empId) {
    	try {
    		return ResponseEntity.ok( employeeService.findByEmpId(empId) );
		} catch (NotFoundException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize(value="hasRole('admin')")
    public ResponseEntity<?> findAllEmployees(@RequestParam(required=false) Long courseId) {
    	if(courseId == null){
    		return ResponseEntity.ok(employeeService.findAllEmployees());
    	}
    	try {
    		return ResponseEntity.ok( employeeService.findByCourseId(courseId) );
		} catch (NotFoundException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
    }
    
    @RequestMapping(value="/{empId}/courses", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findCourses(@PathVariable String empId) {
    	try {
    		return ResponseEntity.ok( courseService.findCourses(empId) );
		} catch (NotFoundException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
    }
}
