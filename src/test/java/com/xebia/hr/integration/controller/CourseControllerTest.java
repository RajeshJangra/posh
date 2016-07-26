package com.xebia.hr.integration.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.xebia.hr.DefaultTestAnnotations;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@DefaultTestAnnotations
public class CourseControllerTest{
	
	@Autowired WebApplicationContext wac; 
	
	private final String find_questions = "/{courseId}/questions";

	private MockMvc mockMvc;
	
	@Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }
	
	@Test
	public void test_findQuestions_with_invalidCourseId_400() throws Exception {
		mockMvc.perform(get("/course"+find_questions, "invalidCourseId")).andExpect(status().isBadRequest());
	}
	
	@Test
	public void test_findQuestions_with_invalidCourseId_404() throws Exception {
		mockMvc.perform(get("/course"+find_questions, 0)).andExpect(status().isNotFound());
	}

}
