package com.xebia.hr.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class CourseDto {

	private long id;
	private String name;
	private String score;
	private String result;
	private int attemptCount;
	
}
