package com.xebia.hr.dto;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class QuestionDto {

	private long id;
	private String name;
	private String desc;
	private String correctChoiceId;
	private String selectedChoiceId;
	private List<ChoiceDto> choices;
}
