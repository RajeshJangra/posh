package com.xebia.hr.task;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.xebia.hr.entity.Employee;
import com.xebia.hr.service.EmployeeService;
import com.xebia.hr.service.MailService;

@Component
public class EmployeeDataFeeder {

	private Logger logger = Logger.getLogger(EmployeeDataFeeder.class);

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
	private PasswordEncoder passwordEncoder;

	private static final SimpleDateFormat passwordDateFormat = new SimpleDateFormat("ddMMyyyy");
	private static final SimpleDateFormat excelDateFormat = new SimpleDateFormat("dd/MM/yy");
	private static final Date CURRENT_DATE = new Date();

	@Scheduled(cron="${induction.schedule.employee-feeder.cron}")
	public void updateEmployees(){

		List<Employee> employees;
		List<Employee> employeeToBeUpdated = new ArrayList<>();
		try {
			employees = getEmployeeFromExcel();
			List<Employee> existingEmployees = employeeService.findAllEmployees();
			for(Employee employee : employees){

				String empId = employee.getEmpId();
				if(StringUtils.isEmpty(empId)){
					continue;
				}

				Optional<Employee> existingEmployee = getExistingEmployee(existingEmployees, employee.getEmpId());
				if(existingEmployee.isPresent()){
					//Update some field if updated in excel
					existingEmployee.get().setName(employee.getName());
					existingEmployee.get().setDesignation(employee.getDesignation());
					existingEmployee.get().setEmpType(employee.getEmpType());
					employee = existingEmployee.get();
				}else{
					//By default, we set password as date of birth, format is ddMMyyyy like 02032013 - 2 March 2013
					employee.setPassword( passwordEncoder.encode(passwordDateFormat.format(employee.getDateOfBirth())) );
					employee.setLastPasswordReset(CURRENT_DATE);
					employee.setActive(true);
				}
				employeeToBeUpdated.add(employee);
			}
			employeeService.save(employeeToBeUpdated);
		} catch (Exception e1) {
			sendExceptionMail(e1);
			e1.printStackTrace();
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
				mailService.sendMail(mailList.split(","), null, null, "Induction Employee Data Process Exception", exception, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private List<Employee> getEmployeeFromExcel() throws Exception{
		List<Employee> employees = null;

		try(	InputStream fs = new FileInputStream (new File(employeeExcelPath));
				Workbook workbook = WorkbookFactory.create(fs) 
				){
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

				Employee employee = null;
				try{
					employee = getEmployee(row);
					employees.add(employee);
				}catch(Exception e){
					//Skipping the employee who do not have mandatory info in Excel
					//We can send exception mail here as well
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return employees;
	}

	private Employee getEmployee(Row row) throws Exception{
		Employee employee = null;
		try {
			employee = new Employee();

			employee.setEmpId(row.getCell(1).getStringCellValue().trim());
			logger.info("Getting employee details for "+employee.getEmpId());
			employee.setName(row.getCell(2).getStringCellValue().trim());
			employee.setEmpType(row.getCell(4, Row.CREATE_NULL_AS_BLANK).getStringCellValue().trim());

			employee.setDateOfBirth(parseDate(row.getCell(5)));
			employee.setDateOfJoining(parseDate(row.getCell(6)));
			employee.setDesignation(row.getCell(8).getStringCellValue().trim());
			employee.setEmail(row.getCell(10).getStringCellValue().trim());
			employee.setGender(row.getCell(12, Row.CREATE_NULL_AS_BLANK).getStringCellValue().trim());
			employee.setAuthorities(row.getCell(13, Row.CREATE_NULL_AS_BLANK).getStringCellValue().trim());
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
			throw e;
		}
		return employee;
	}

	private Date parseDate(Cell cell) throws ParseException {
		Date dob;
		try{
			dob = cell.getDateCellValue();
		}catch(Exception e){
			//If exception then try to convert string to date
			String value = cell.getStringCellValue();
			dob = excelDateFormat.parse(value);
		}
		return dob;
	}


}
