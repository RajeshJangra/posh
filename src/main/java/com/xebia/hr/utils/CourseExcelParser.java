package com.xebia.hr.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xebia.hr.entity.Choice;
import com.xebia.hr.entity.Course;
import com.xebia.hr.entity.Question;
import com.xebia.hr.service.ChoiceService;
import com.xebia.hr.service.CourseService;
import com.xebia.hr.service.QuestionService;

@Component
public class CourseExcelParser {
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private ChoiceService choiceService;
	
	public void parseExcel() throws Exception{

		try(	InputStream fs = new FileInputStream (new File("C:\\Users\\gauravagrawal\\Documents\\Xebia\\Projects\\Induction\\POSH_QnA.xls"));
				Workbook workbook = WorkbookFactory.create(fs) 
				){
			Sheet courseSheet = workbook.getSheet("Courses");
			Iterator<Row> rowIterator = courseSheet.rowIterator();
			int count = 0;
			while(rowIterator.hasNext()){
				Row row = rowIterator.next();
				++count;
				//Skip first row
				if(count <= 1){
					continue;
				}
				Course course = new Course();
				String courseName = row.getCell(0).getStringCellValue();
				course.setName(courseName);
				course.setDescription(row.getCell(1).getStringCellValue());
				dumpCourseAndItsQnA(course, workbook);
			}
				
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}
	
	private void dumpCourseAndItsQnA(Course course, Workbook workbook) {
		Course savedCourse = courseService.save(course);
		Sheet sheet = workbook.getSheet(course.getName());
		Iterator<Row> rowIterator = sheet.rowIterator();
		int count = 0;
		while(rowIterator.hasNext()){
			Row row = rowIterator.next();
			++count;
			//Skip first row
			if(count <= 1){
				continue;
			}
			addChoices(row, savedCourse);
		}
	}

	private void addChoices(Row row, Course savedCourse) {
		Question ques = new Question();
		ques.setDescription(row.getCell(0).getStringCellValue());
		ques.setCourse(savedCourse);
		Question savedQues = questionService.save(ques);
		String answer = row.getCell(1).getStringCellValue();
		
		//Choice 1 to 5
		for(int i=2; i<=6; i++){
			
			Cell cell = row.getCell(i);
			if(Objects.isNull(cell)){
				break;
			}
			String val = cell.getStringCellValue();
			if(!StringUtils.isNotEmpty(val)){
				break;
			}
			
			Choice choice = new Choice();
			choice.setDescription(val);
			choice.setQuestion(savedQues);
			Choice savedChoice = choiceService.save(choice);
			
			if(savedChoice.getDescription().equals(answer)){
				savedQues.setAnswer(String.valueOf(savedChoice.getId()));
				questionService.save(savedQues);
			}
		}
	}

}
