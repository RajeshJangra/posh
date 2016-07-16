package com.xebia.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.xebia.hr.dto.CourseDto;
import com.xebia.hr.entity.Employee;
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
    @ResponseBody
    public Employee createUser(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Employee findUserbyId(@PathVariable String id) {
        return employeeService.findEmployeeById(id);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Employee> findAllEmployees(@RequestParam Long courseId) {
        return courseId == null ? employeeService.findAllEmployees() : employeeService.findByCourseId(courseId);
    }
    
    @RequestMapping(value="/{empId}/courses", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CourseDto> findCourses(@PathVariable String empId) {
    	return courseService.findCourses(empId);
    }
}
