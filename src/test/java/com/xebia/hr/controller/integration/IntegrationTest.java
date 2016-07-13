package com.xebia.hr.controller.integration;

import com.xebia.hr.config.Application;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(Cucumber.class)
@CucumberOptions(format = {"pretty", "html:target/cucumber"}, features = "classpath:cucumber/employee.feature", glue = {"com.xebia.hr.controller.integration"})
//@WebAppConfiguration
public class IntegrationTest {
}
