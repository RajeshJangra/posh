package com.xebia.hr.controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xebia.hr.constants.AppConstants;
import com.xebia.hr.dto.BasicResponse;
import com.xebia.hr.dto.CourseDto;
import com.xebia.hr.dto.QuestionDto;
import com.xebia.hr.dto.QuestionsWrapper;
import com.xebia.hr.entity.Attempt;
import com.xebia.hr.entity.Course;
import com.xebia.hr.exceptions.NotFoundException;
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

	@Autowired
	private ResourceLoader resourceLoader;
	
	@Value("${induction.course.quiz.question.limit}")
	private Integer quizQuesLimit;
	
	@Value("${induction.course.maxAttempt}")
	private Integer maxAttempt;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Course> findAll() {
		return courseService.findAll();
	}

	@RequestMapping(value="/{courseId}/pdf", method = RequestMethod.GET)
	public ResponseEntity<?> showPdf(@PathVariable Long courseId,  HttpServletResponse response) {

		Course course = null;
		try{
			course = courseService.findOne(courseId);
		}catch(Exception e){
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}

		try(InputStream iStream = resourceLoader.getResource("classpath:public/SamplePDFFile_5mb.pdf").getInputStream()){
			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "inline; filename="+"test".replace(" ", "_"));
			byte[] buffer = new byte[10240];

			try (
					OutputStream output = response.getOutputStream();
					) {
				for (int length = 0; (length = iStream.read(buffer)) > 0;) {
					output.write(buffer, 0, length);
				}
			}
			response.flushBuffer();
			return ResponseEntity.ok(new BasicResponse(""));
		}catch(Exception e){
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value="/{courseId}/questions", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findQuestions(@PathVariable long courseId) {
		try{
			List<QuestionDto> questions = questionService.findAllQuestions(courseId);
			return ResponseEntity.ok(questions);
		} catch(NotFoundException nfe){
			return new ResponseEntity(nfe.getMessage(), HttpStatus.NOT_FOUND);
		} catch(Exception e){
			return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value="/{courseId}/start/{empId}", method = RequestMethod.GET)
	public ResponseEntity<?> startCourse(@PathVariable long courseId, @PathVariable String empId) {
		try{
			//if emp is already passed the course, no need to start
			List<Attempt> attempts = attemptService.findByCourseAndEmployee(courseId, empId);
			if(attempts != null && attempts.size() > 0){
				Collections.sort(attempts);
				Attempt latestAttempt = attempts.get(attempts.size()-1);
				if(AppConstants.PASSED.equals(latestAttempt.getResult())){
					return ResponseEntity.badRequest().body("Employee already cleared the test. Can not take test again.");
				}

				//If emp attempted 3 times then block the course
				if(attempts.size() >= maxAttempt){
					return ResponseEntity.badRequest().body("Number of course attempt limit is exceeded.");
				}
			}
			
			List<QuestionDto> questions = questionService.findRandomQuestions(courseId, quizQuesLimit);
			Attempt attempt = attemptService.savePartially(courseId, empId, questions.size());
			return ResponseEntity.ok(new QuestionsWrapper(attempt.getId(), questions));
		} catch(NotFoundException nfe){
			return new ResponseEntity(nfe.getMessage(), HttpStatus.NOT_FOUND);
		} catch(Exception e){
			return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value="/submit/{attemptId}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> submitCourse(@RequestBody List<QuestionDto> questions, @PathVariable long attemptId) throws Exception {

		// In-case of submit/quit/session timeout
		try{
			courseService.submitCourse(questions, attemptId);
			return ResponseEntity.ok(new BasicResponse("Course submitted successfully."));
		} catch(NotFoundException nfe){
			return new ResponseEntity(nfe.getMessage(), HttpStatus.NOT_FOUND);
		} catch(Exception e){
			return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/scorecard/{attemptId}")
	public ResponseEntity<?> getScoreCard(@PathVariable long attemptId) throws Exception {
		try{
			CourseDto dto = courseService.getScoreCard(attemptId);
			return ResponseEntity.ok(dto);
		} catch(NotFoundException nfe){
			return new ResponseEntity(nfe.getMessage(), HttpStatus.NOT_FOUND);
		} catch(Exception e){
			return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
