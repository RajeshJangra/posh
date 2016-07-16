package com.xebia.hr.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xebia.hr.Converter.QuestionConverter;
import com.xebia.hr.dto.QuestionDto;
import com.xebia.hr.entity.Course;
import com.xebia.hr.entity.Question;
import com.xebia.hr.repository.CourseRepository;
import com.xebia.hr.repository.QuestionRepository;


/**
 * @author gauravagrawal
 * @since 15 July, 16
 */
@Service
public class QuestionService {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private CourseRepository courseRepository; 
	
	public List<QuestionDto> findQuestions(long courseId){
		Course course = courseRepository.findOne(courseId);
		List<Question> questions = questionRepository.findByCourse(course);
		
    	List<QuestionDto> dtos = new ArrayList<>(questions.size());
    	for(Question question : questions){
    		QuestionDto dto = QuestionConverter.CONVERT_QUESTION_TO_QUESTION_DTO.apply(question);
        	dtos.add(dto);
    	}
    	return dtos;
	}
    
}
