package com.xebia.hr.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xebia.hr.constants.AppConstants;
import com.xebia.hr.entity.Attempt;
import com.xebia.hr.entity.Course;
import com.xebia.hr.entity.Employee;
import com.xebia.hr.exceptions.NotFoundException;
import com.xebia.hr.repository.AttemptRepository;
import com.xebia.hr.repository.CourseRepository;
import com.xebia.hr.repository.EmployeeRepository;


/**
 * @author gauravagrawal
 * @since 15 July, 16
 */
@Service
public class AttemptService {

    @Autowired
    private AttemptRepository attemptRepository;
    
    @Autowired
    private CourseRepository courseRepository;
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    public Attempt findOne(long id) throws Exception{
    	Attempt attempt = attemptRepository.findOne(id);
    	if(Objects.isNull(attempt)){
			throw new NotFoundException("Invalid attempt id"+ id);
		}
    	return attempt;
    }
    
    public Attempt save(Attempt attempt){
    	return attemptRepository.save(attempt);
    }
    
    public Attempt savePartially(long courseId, String empId){
    	Course course = courseRepository.findOne(courseId);
    	Employee employee = employeeRepository.findByEmpId(empId);
    	
    	Attempt attempt = new Attempt();
    	attempt.setCourse(course);
    	attempt.setEmployee(employee);
    	attempt.setStartTime( new Timestamp(System.currentTimeMillis()) );
    	attempt.setResult(AppConstants.IN_PROGRESS);
    	return attemptRepository.save(attempt);
    }
    
    public List<Attempt> findByCourseAndEmployee(long courseId, String empId){
    	Course course = courseRepository.findOne(courseId);
    	Employee employee = employeeRepository.findByEmpId(empId);
    	return attemptRepository.findByCourseAndEmployee(course, employee);
    };
    
    public List<Attempt> findAllAttempts() {
        return attemptRepository.findAll();
    }
    
    public List<Attempt> findByCourse(Course course){
    	return attemptRepository.findByCourse(course);
    }
    
}
