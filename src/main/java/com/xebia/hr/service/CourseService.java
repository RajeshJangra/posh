package com.xebia.hr.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xebia.hr.Converter.CourseConverter;
import com.xebia.hr.dto.CourseDto;
import com.xebia.hr.entity.Attempt;
import com.xebia.hr.entity.Course;
import com.xebia.hr.entity.Employee;
import com.xebia.hr.repository.AttemptRepository;
import com.xebia.hr.repository.CourseRepository;


/**
 * @author gauravagrawal
 * @since 15 July, 16
 */
@Service
public class CourseService {
	
	@Autowired
	private EmployeeService employeeService;
	
    @Autowired
    private CourseRepository courseRepository;
    
    @Autowired
    private AttemptRepository attemptRepository;

    public List<Course> findAll(){
    	List<Course> courses = courseRepository.findAll();
    	return courses;
    }
    
    public Course save(Course course){
    	return courseRepository.save(course);
    }
    
    public List<CourseDto> findCourses(String empId){
    	Employee employee = employeeService.findEmployeeById(empId);
    	List<Course> courses = courseRepository.findByEmployees(employee);
    	
    	List<CourseDto> dtos = new ArrayList<>(courses.size());
    	for(Course course : courses){
    		List<Attempt> attempts = attemptRepository.findByCourseAndEmployee(course, employee);
    		CourseDto courseDto = CourseConverter.CONVERT_COURSE_TO_COURSE_DTO.apply(attempts, course);
        	dtos.add(courseDto);
    	}
    	return dtos;
    }
    
}
