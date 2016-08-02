package com.xebia.hr.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.xebia.hr.DefaultTestAnnotations;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@DefaultTestAnnotations
public class CourseExcelParserTest {

	@Autowired
	private CourseExcelParser courseExcelParser;
	
	@Test
	public void test() throws Exception {
		courseExcelParser.parseExcel();
	}

}
