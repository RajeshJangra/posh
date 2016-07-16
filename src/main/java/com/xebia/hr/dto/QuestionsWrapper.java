package com.xebia.hr.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class QuestionsWrapper {

	private long attemptId;
	private List<QuestionDto> questions;
	
}
