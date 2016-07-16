package com.xebia.hr.Converter;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.xebia.hr.dto.ChoiceDto;
import com.xebia.hr.dto.QuestionDto;
import com.xebia.hr.entity.Choice;
import com.xebia.hr.entity.Question;

public class QuestionConverter {

	public static final Function<Question, QuestionDto> CONVERT_QUESTION_TO_QUESTION_DTO =
			(question) -> {
				QuestionDto questionDto = new QuestionDto();
				questionDto.setId(question.getId());
				questionDto.setName(question.getName());
				questionDto.setDesc(question.getDescription());
				questionDto.setCorrectChoiceId(question.getAnswer());

				List<ChoiceDto> choices = question.getChoices()
						.stream()
						.map( e -> QuestionConverter.CONVERT_CHOICE_TO_CHOICE_DTO.apply(e) )
						.collect(Collectors.<ChoiceDto>toList());
				
				questionDto.setChoices(choices);
				return questionDto;
			};

	public static final Function<Choice, ChoiceDto> CONVERT_CHOICE_TO_CHOICE_DTO = 
			choice -> {
				ChoiceDto dto = new ChoiceDto();
				dto.setId(choice.getId());
				dto.setDesc(choice.getDescription());
				return dto;
			};	
			
}
