package com.xebia.hr.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xebia.hr.Converter.QuestionConverter;
import com.xebia.hr.dto.QuestionDto;
import com.xebia.hr.entity.Course;
import com.xebia.hr.entity.Question;
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
	private CourseService courseService; 
	
	public List<QuestionDto> findAllQuestions(long courseId) throws Exception {
		Course course = courseService.findOne(courseId);
		List<Question> questions = questionRepository.findByCourse(course);
		
    	List<QuestionDto> dtos = new ArrayList<>(questions.size());
    	for(Question question : questions){
    		QuestionDto dto = QuestionConverter.CONVERT_QUESTION_TO_QUESTION_DTO.apply(question);
        	dtos.add(dto);
    	}
    	return dtos;
	}
	
	public List<QuestionDto> findRandomQuestions(long courseId, int numberOfQuestions) throws Exception {
		Course course = courseService.findOne(courseId);
		List<Question> questions = questionRepository.findByCourse(course);
		List<Question> randomQuestions = new ArrayList<>(numberOfQuestions);
		
		Collections.shuffle(questions);
		int totalQues = questions.size();
	    for (int i = 0; i < Math.min(numberOfQuestions, totalQues); i++) {
	        randomQuestions.add( questions.get(i) );
	    }
	    List<QuestionDto> dtos = new ArrayList<>(numberOfQuestions);
    	for(Question question : randomQuestions){
    		QuestionDto dto = QuestionConverter.CONVERT_QUESTION_TO_QUESTION_DTO.apply(question);
        	dtos.add(dto);
    	}
    	return dtos;
	}
	
	public Question save(Question question){
		return questionRepository.save(question);
	}
    
}
