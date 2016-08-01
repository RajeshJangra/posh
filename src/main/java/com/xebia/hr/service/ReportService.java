package com.xebia.hr.service;

import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xebia.hr.constants.AppConstants;
import com.xebia.hr.entity.Attempt;
import com.xebia.hr.entity.Course;
import com.xebia.hr.entity.Employee;
import com.xebia.hr.utils.CommonUtils;

/**
 * @author gauravagrawal
 */
@Service
public class ReportService {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private AttemptService attemptService;

	public XSSFWorkbook getCourseReport(Course course) {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet spreadsheet = workbook.createSheet("Data");
		XSSFRow row = null;
		// Course course = courseService.findOne(courseId);
		List<Employee> employees = employeeService.findAllEmployees();
		List<Attempt> attempts = attemptService.findByCourse(course);

		int rowid = 0;
		int cellid = 0;
		row = spreadsheet.createRow(rowid++);
		for (int i = 0; i < AppConstants.COURSE_REPORT_HEADERS.length; i++) {
			Cell cell = row.createCell(cellid++);
			if (i == 5) {
				cell.setCellValue(AppConstants.COURSE_REPORT_HEADERS[i].replace("TrainingName", course.getName()));
			} else {
				cell.setCellValue(AppConstants.COURSE_REPORT_HEADERS[i]);
			}
		}

		for (Employee employee : employees) {
			int sNo = 0;
			int attempsCount = 0;
			boolean isAppeared = false;
			boolean isCleared = false;
			int score = 0;
			for (Attempt attempt : attempts) {
				if (employee.getId() == attempt.getEmployee().getId()) {
					isAppeared = true;
					++attempsCount;
					if (AppConstants.PASSED.equals(attempt.getResult())) {
						isCleared = true;
						score = CommonUtils.calculatepercentage(Integer.parseInt(attempt.getScore()),
								Integer.parseInt(attempt.getMaxScore()));
					}
				}
			}

			cellid = 0;
			row = spreadsheet.createRow(rowid++);
			for (int i = 0; i < AppConstants.COURSE_REPORT_HEADERS.length; i++) {
				Cell cell = row.createCell(cellid++);
				switch (i) {
				case 0:
					cell.setCellValue(++sNo);
					break;
				case 1:
					cell.setCellValue(employee.getEmpId());
					break;
				case 2:
					cell.setCellValue(employee.getName());
					break;
				case 3:
					cell.setCellValue(employee.getDesignation());
					break;
				case 4:
					cell.setCellValue(employee.getGender());
					break;
				case 5:
					if (isAppeared) {
						cell.setCellValue("YES");
					} else {
						cell.setCellValue("NO");
					}
					break;
				case 6:
					if (isAppeared) {
						if (isCleared) {
							cell.setCellValue("PASSED");
						} else {
							cell.setCellValue("FAILED");
						}
					}
					break;
				case 7:
					if (isCleared) {
						cell.setCellValue(score);
					}
					break;
				case 8:
					if (isCleared) {
						cell.setCellValue(attempsCount);
					}
					break;

				}
			}

		}

		return workbook;
	}

}
