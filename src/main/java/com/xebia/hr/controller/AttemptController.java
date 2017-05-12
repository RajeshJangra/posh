package com.xebia.hr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xebia.hr.service.AttemptArchiveService;
import com.xebia.hr.service.AttemptService;

@RestController
@RequestMapping("/attempt")
public class AttemptController {

	@Autowired
	AttemptService attemptService;
	
	@Autowired
	AttemptArchiveService attemptArchiveService;
	
	@Value("${induction.course.maxAttempt}")
	private Integer maxAttempt;
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/reset")
	public void resetAttempt(@RequestParam long employeeId) {
		attemptService.deleteByEmployeeId(employeeId);
	}

}
