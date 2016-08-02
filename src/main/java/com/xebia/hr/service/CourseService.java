package com.xebia.hr.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xebia.hr.Converter.CourseConverter;
import com.xebia.hr.constants.AppConstants;
import com.xebia.hr.dto.CourseDto;
import com.xebia.hr.dto.QuestionDto;
import com.xebia.hr.entity.Attempt;
import com.xebia.hr.entity.Course;
import com.xebia.hr.entity.Employee;
import com.xebia.hr.repository.AttemptRepository;
import com.xebia.hr.repository.CourseRepository;
import com.xebia.hr.utils.CommonUtils;


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
    
    @Autowired
    private AttemptService attemptService;
    
    @Autowired
	private QuestionService questionService;

    public List<Course> findAll(){
    	List<Course> courses = courseRepository.findAll();
    	return courses;
    }
    
    public Course save(Course course){
    	return courseRepository.save(course);
    }
    
    public List<CourseDto> findCourses(String empId){
    	Employee employee = employeeService.findByEmpId(empId);
    	List<Course> courses = courseRepository.findByEmployees(employee);
    	
    	List<CourseDto> dtos = new ArrayList<>(courses.size());
    	for(Course course : courses){
    		List<Attempt> attempts = attemptRepository.findByCourseAndEmployee(course, employee);
    		CourseDto courseDto = CourseConverter.CONVERT_COURSE_TO_COURSE_DTO.apply(attempts, course);
        	dtos.add(courseDto);
    	}
    	return dtos;
    }
    
    public Course findOne(Long courseId){
    	return courseRepository.findOne(courseId);
    }
    
    public CourseDto submitCourse(List<QuestionDto> questions, long attemptId) throws Exception{
    	
    	Attempt attempt = attemptService.findOne(attemptId);
    	int actualScore = 0;
		List<QuestionDto> actualQues = questionService.findQuestions(attempt.getCourse().getId());
		int maxScore = actualQues.size();

		HashMap<Long, QuestionDto> questionmap = new HashMap<>();

		for(QuestionDto question : actualQues){
			questionmap.put(Long.valueOf(question.getId()), question);
		}

		for (QuestionDto question : questions) {
			QuestionDto questiondb = questionmap.get(question.getId());
			if (question.getSelectedChoiceId().equals(questiondb.getCorrectChoiceId())) {
				actualScore++;
			}
		}
		int percentage = CommonUtils.calculatepercentage(actualScore, maxScore); 

		if (percentage >= 90) {
			attempt.setResult(AppConstants.PASSED);
		} else {
			attempt.setResult(AppConstants.FAILED);
		}
		attempt.setFinishTime(new Timestamp(System.currentTimeMillis())); 
		attempt.setMaxScore(maxScore);
		attempt.setScore(actualScore);
		attempt.setScoreInPercent(Double.valueOf(percentage)); 
		attemptService.save(attempt);

    	return CourseConverter.CONVERT_ATTEMPT_TO_COURSE_DTO.apply(attempt);
    }
    
}
