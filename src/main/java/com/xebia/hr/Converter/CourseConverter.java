package com.xebia.hr.Converter;

import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;

import com.xebia.hr.constants.AppConstants;
import com.xebia.hr.dto.CourseDto;
import com.xebia.hr.entity.Attempt;
import com.xebia.hr.entity.Course;

public class CourseConverter {

	public static final BiFunction<List<Attempt>, Course, CourseDto> CONVERT_COURSE_TO_COURSE_DTO =
			(attempts, course) -> {
				
				CourseDto courseDto = new CourseDto();
				course.setId(course.getId());
				courseDto.setName(course.getName());
				if(attempts != null && attempts.size() > 0){
					//Find latest attempt from attempts
					Attempt attempt = getLatestAttempt(attempts);
					courseDto.setResult(attempt.getResult());
					courseDto.setScore(attempt.getScore());
					courseDto.setAttemptCount(attempts.size());
				} else {
	        		courseDto.setResult(AppConstants.NOT_STARTED);
				}
				return courseDto;
			};

	private static Attempt getLatestAttempt(List<Attempt> attempts) {
		Collections.sort(attempts);
		return attempts.get(attempts.size()-1); //Most recent will go in last
	}

}
