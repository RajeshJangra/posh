package com.xebia.hr.controller;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xebia.hr.entity.Course;
import com.xebia.hr.service.CourseService;
import com.xebia.hr.service.ReportService;

/**
 * @author gauravagrawal
 */
@RestController
@RequestMapping("/report")
public class ReportController {

	@Autowired
	private ReportService reportService;
	
	@Autowired
	private CourseService courseService;
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/course/{courseId}", method = RequestMethod.GET)
	public ResponseEntity<?> downloadCourseReport(@PathVariable Long courseId, HttpServletResponse response) {

		try {
			Course course = courseService.findOne(courseId);
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "attachment; filename=" + course.getName().replace(" ", "_")+".xlsx");
			XSSFWorkbook workbook = reportService.getCourseReport(course);
			workbook.write(response.getOutputStream());
			workbook.close();
			return ResponseEntity.ok("");
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
