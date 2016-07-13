$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("cucumber/employee.feature");
formatter.feature({
  "line": 1,
  "name": "Employee",
  "description": "As an employee\nI want to fetch all the employees from mobility system",
  "id": "employee",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 5,
  "name": "Fetch list of all employees",
  "description": "",
  "id": "employee;fetch-list-of-all-employees",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "Two employees exist in mobility system",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "I fetch all employees",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "the result should be two employees",
  "keyword": "Then "
});
formatter.match({
  "location": "EmployeeStepDefs.two_employees_exist_in_mobility_system()"
});
formatter.result({
  "duration": 181805616,
  "status": "passed"
});
formatter.match({
  "location": "EmployeeStepDefs.i_fetch_all_employees()"
});
formatter.result({
  "duration": 53647,
  "status": "passed"
});
formatter.match({
  "location": "EmployeeStepDefs.the_result_should_be_two_employees()"
});
formatter.result({
  "duration": 20203,
  "status": "passed"
});
});