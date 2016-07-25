package com.xebia.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xebia.hr.dto.QuestionDto;
import com.xebia.hr.dto.QuestionsWrapper;
import com.xebia.hr.entity.Attempt;
import com.xebia.hr.entity.Course;
import com.xebia.hr.service.AttemptService;
import com.xebia.hr.service.CourseService;
import com.xebia.hr.service.QuestionService;

/**
 * @author gauravagrawal
 * @since 15 July, 16
 */
@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;
    
    @Autowired
    private QuestionService questionService;
    
    @Autowired
    private AttemptService attemptService;
    
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Course> findAll() {
        return courseService.findAll();
    }
    
    @RequestMapping(value="/{courseId}/questions", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<QuestionDto> findCourses(@PathVariable long courseId) {
    	return questionService.findQuestions(courseId);
    }
    
    //By the way we can use token to find the empId TODO
    @RequestMapping(value="/{courseId}/start/{empId}", method = RequestMethod.GET)
    public QuestionsWrapper startCourse(@PathVariable long courseId, @PathVariable String empId) {
    	
    	//validation TODO
    	//if emp is already passed the course, no need to start
    	//If emp attempted 3 times then block the course
    	
		Attempt attempt = attemptService.savePartially(courseId, empId);
		List<QuestionDto> questions = questionService.findQuestions(courseId);
    	return new QuestionsWrapper(attempt.getId(), questions);
    }
    
    @RequestMapping(value="/submit/{attemptId}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Attempt submitCourse(@RequestBody List<QuestionDto> questions, @PathVariable long attemptId) {
    	
    	//incase of submit/quit/session timeout
    	
    	Attempt attempt = attemptService.findOne(attemptId);
    	/*attempt.setFinishTime(finishTime);
    	attempt.setMaxScore(maxScore);
    	attempt.setResult(result);
    	attempt.setScore(score);*/
    	return attemptService.save(attempt);
    }
    
    
    
}
