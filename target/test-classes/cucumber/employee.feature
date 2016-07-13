Feature: Employee
  As an employee
  I want to fetch all the employees from mobility system

  Scenario: Fetch list of all employees
    Given Two employees exist in mobility system
    When I fetch all employees
    Then the result should be two employees