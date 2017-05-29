package com.xebia.hr.controller;

import com.xebia.hr.entity.Employee;
import com.xebia.hr.exceptions.NotFoundException;
import com.xebia.hr.service.AttemptArchiveService;
import com.xebia.hr.service.AttemptService;
import com.xebia.hr.service.CourseService;
import com.xebia.hr.service.EmployeeService;
import com.xebia.hr.task.EmployeeDataFeeder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final static Logger log = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CourseService courseService;

    @Autowired(required = false)
    private AttemptService attemptService;

    @Autowired(required = false)
    private AttemptArchiveService attemptArchiveService;

    @Autowired
    private EmployeeDataFeeder employeeDataFeeder;

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize(value = "hasRole('admin')")
    public Employee createUser(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @RequestMapping(value = "{empId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize(value = "hasRole('admin')")
    public ResponseEntity<?> findUserbyId(@PathVariable String empId) {
        try {
            return ResponseEntity.ok(employeeService.findByEmpId(empId));
        } catch (NotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize(value = "hasRole('admin')")
    public ResponseEntity<?> findAllEmployees(@RequestParam(required = false) Long courseId) {
        if (courseId == null) {
            return ResponseEntity.ok(employeeService.findAllEmployees());
        }
        try {
            return ResponseEntity.ok(employeeService.findByCourseId(courseId));
        } catch (NotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{empId}/courses", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findCourses(@PathVariable String empId) {
        log.info("Calling findCourses: employeeId: " + empId);
        try {
            return ResponseEntity.ok(courseService.findCourses(empId));
        } catch (NotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    @PreAuthorize(value = "hasRole('admin')")
    public ResponseEntity<?> updateEmployeesFromExcel() {
        log.info("Calling updateEmployeesFromExcel: Going to update the employee from excel");
        try {
            employeeDataFeeder.updateEmployees();
            return ResponseEntity.ok("Success");
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "{empId}/attempts", method = RequestMethod.DELETE)
    @PreAuthorize(value = "hasRole('admin')")
    public ResponseEntity<?> clearAttempts(@PathVariable String empId) throws NotFoundException {
        try {
            attemptService.deleteAttempts(employeeService.findByEmpId(empId).getId());
            return ResponseEntity.ok("Success");
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
