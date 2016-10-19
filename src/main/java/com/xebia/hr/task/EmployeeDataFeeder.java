package com.xebia.hr.task;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.xebia.hr.entity.Course;
import com.xebia.hr.entity.Employee;
import com.xebia.hr.service.CourseService;
import com.xebia.hr.service.EmployeeService;
import com.xebia.hr.service.MailService;

@Component
public class EmployeeDataFeeder {

	private final static Logger logger = LoggerFactory.getLogger(EmployeeDataFeeder.class);

	@Value("${mail.list}")
	private String mailList;

	@Value("${induction.errorInCase.mail.enable}")
	private String mailEnableInCaseError;

	@Value("${induction.hr.employee.excel.path}")
	private String employeeExcelPath;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private MailService mailService;

	@Autowired
	private CourseService courseService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	private static final SimpleDateFormat passwordDateFormat = new SimpleDateFormat("ddMMyyyy");
	private static final SimpleDateFormat excelDateFormat = new SimpleDateFormat("dd/MM/yy");
	private static final Date CURRENT_DATE = new Date();

	@Scheduled(cron="${induction.schedule.employee-feeder.cron}")
	public void updateEmployees(){

		logger.info("Calling EmployeeDataFeeder's updateEmployees() method");
		List<Employee> employeeToBeUpdated = new ArrayList<>();
		try {
			List<Employee> employees = getEmployeeFromExcel();
			List<Employee> existingEmployees = employeeService.findAllEmployees();
			List<Course> courses = courseService.findAll();
			Set<Course> uniqueCourses = new HashSet<>(courses);
			for(Employee employee : employees){

				Optional<Employee> existingEmployee = getExistingEmployee(existingEmployees, employee.getEmpId());
				if(existingEmployee.isPresent()){
					//Update some field if updated in excel
					existingEmployee.get().setName(employee.getName());
					existingEmployee.get().setDesignation(employee.getDesignation());
					existingEmployee.get().setEmpType(employee.getEmpType());
					existingEmployee.get().setAuthorities(employee.getAuthorities());
					existingEmployee.get().setContactNumber(employee.getContactNumber());
					existingEmployee.get().setDateOfBirth(employee.getDateOfBirth());
					existingEmployee.get().setDateOfJoining(employee.getDateOfJoining());
					existingEmployee.get().setEmail(employee.getEmail());
					existingEmployee.get().setGender(employee.getGender());
					employee = existingEmployee.get();
				}else{
					logger.info("New employee to be added: "+employee.getEmpId());
					//By default, we set password as date of birth, format is ddMMyyyy like 02032013 - 2 March 2013
					employee.setPassword( passwordEncoder.encode(passwordDateFormat.format(employee.getDateOfBirth())) );
					employee.setLastPasswordReset(CURRENT_DATE);
					employee.setActive(true);
				}
				employee.setCourses(uniqueCourses);
				employeeToBeUpdated.add(employee);
			}
			employeeService.save(employeeToBeUpdated);
			logger.info("Successfully updated the employees.");
		} catch (Exception e1) {
			logger.error("Error:", e1);
			sendExceptionMail(e1);
		}

	}

	private Optional<Employee> getExistingEmployee(final List<Employee> employees, final String empId){
		return employees.stream().filter(employee -> empId.equals(employee.getEmpId())).findFirst();
	}

	private void sendExceptionMail(Exception e1) {
		//send mail to HR regarding this exception
		try {
			if("true".equalsIgnoreCase(mailEnableInCaseError)){
				String exception = ExceptionUtils.getStackTrace(e1);
				logger.info("Sending exception mail");
				mailService.sendMail(mailList.split(","), null, null, "Induction Employee Data Process Exception", exception, null);
			}
		} catch (Exception e) {
			logger.error("Error:", e);
		}
	}

	private List<Employee> getEmployeeFromExcel() throws Exception{
		List<Employee> employees = null;

		try(	InputStream fs = new FileInputStream (new File(employeeExcelPath));
				Workbook workbook = WorkbookFactory.create(fs) 
				){
			logger.info("Reading employees from "+employeeExcelPath);
			employees = new ArrayList<>();
			Sheet sheet = workbook.getSheetAt(0);

			Iterator<Row> rowIterator = sheet.rowIterator();
			int count = 0;
			while(rowIterator.hasNext()){

				Row row = rowIterator.next();
				++count;
				//Skip first and second row
				if(count <= 2){
					continue;
				}

				Employee employee = getEmployee(row);
				if(Objects.nonNull(employee)){
					employees.add(employee);
				}
			}
		}catch(Exception e){
			throw e;
		}
		return employees;
	}

	private Employee getEmployee(Row row){
		try {
			Employee employee = new Employee();
			
			String empId = row.getCell(1).getStringCellValue().trim();
			logger.info("Reading employee details for "+empId);
			employee.setEmpId(empId);
			
			employee.setName(row.getCell(2).getStringCellValue().trim());
			employee.setEmpType(row.getCell(4, Row.CREATE_NULL_AS_BLANK).getStringCellValue().trim());

			Date dob = parseDate(row.getCell(5));
			Date doj = parseDate(row.getCell(6));
			if(Objects.isNull(dob)){
				throw new IllegalArgumentException("DOB are must. Please provide in excel.");
			}
			employee.setDateOfBirth(dob);
			employee.setDateOfJoining(doj);
			employee.setDesignation(row.getCell(8).getStringCellValue().trim());
			employee.setEmail(row.getCell(10).getStringCellValue().trim());
			employee.setGender(row.getCell(12, Row.CREATE_NULL_AS_BLANK).getStringCellValue().trim());
			
			String authorities = row.getCell(13, Row.CREATE_NULL_AS_BLANK).getStringCellValue().trim();
			if(StringUtils.isEmpty(authorities)){
				authorities = "user";
			}
			employee.setAuthorities(authorities);
			return employee;
		} catch (Exception e) {
			logger.error("Skipping the employee who do not have mandatory info in Excel", e);
			return null;
		}
	}

	private Date parseDate(Cell cell) throws Exception {
		Date dob = null;
		try{
			dob = cell.getDateCellValue();
			return dob;
		}catch(Exception e){
			//If exception then try to convert string to date
			String value = cell.getStringCellValue().trim();
			try {
				dob = excelDateFormat.parse(value);
				return dob;
			} catch (Exception e1) {
				throw e1;
			}
		}
	}


}
