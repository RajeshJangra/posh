package com.xebia.hr.constants;

public interface AppConstants {

	/**
	 * Courses's result states
	 */
	public String PASSED = "PASSED";
	public String FAILED = "FAILED";
	public String NOT_STARTED = "NOT STARTED";
	public String IN_PROGRESS = "IN PROGRESS";

	public String X_AUTH_TOKEN = "X-Auth-Token";

	public String[] COURSE_REPORT_HEADERS = { "S.No", "Emp Code", "Name", "Designation", "Gender",
			"Appeared for TrainingName online training", "If Yes then cleared the test",
			"If cleared the test then the score", "No of attempts in which test is cleared." };
}
