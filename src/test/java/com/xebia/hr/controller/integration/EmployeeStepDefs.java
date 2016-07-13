/*
 * Proprietary and confidential
 *  Copyright (C) Mckinsey & Company, Inc - All Rights Reserved (2016)
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 */

package com.xebia.hr.controller.integration;

import com.xebia.hr.config.Application;
import com.xebia.hr.repository.EmployeeRepository;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by RAJESHKUMAR on 6/1/16.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
/*@ContextConfiguration(classes = {Application.class})
@WebAppConfiguration
//@Transactional
@DirtiesContext
@WebIntegrationTest*/
@SpringApplicationConfiguration(classes = Application.class)
public class EmployeeStepDefs {
/*    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;*/

    @Autowired
    EmployeeRepository employeeRepository;

    @Given("^Two employees exist in mobility system$")
    public void two_employees_exist_in_mobility_system() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        employeeRepository.findAll();
    }

    @When("^I fetch all employees$")
    public void i_fetch_all_employees() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
    }

    @Then("^the result should be two employees$")
    public void the_result_should_be_two_employees() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
    }
}
