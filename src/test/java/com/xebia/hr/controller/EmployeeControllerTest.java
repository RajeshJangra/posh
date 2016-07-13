package com.xebia.hr.controller;

import com.xebia.hr.config.Application;
import com.xebia.hr.entity.Employee;
import com.xebia.hr.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * EmployeeController Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Jun 23, 2016</pre>
 */
@RunWith(MockitoJUnitRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class EmployeeControllerTest {

/*    @Value("${local.server.port}")
    int port;*/

    @InjectMocks
    EmployeeController employeeController;

    /*@Mock
    EmployeeService employeeService;*/

    /**
     * Method: createUser(@RequestBody Employee employee)
     */
    @Test
    public void testCreateUser() throws Exception {
        EmployeeService employeeService = mock(EmployeeService.class);
        Employee t = new Employee();
        t.setContactNumber("123456");
        when(employeeService.createEmployee(null)).thenReturn(t);
        ReflectionTestUtils.setField(employeeController, "employeeService", employeeService);
        Employee user = employeeController.createUser(null);
        assertEquals(t, user);
    }

    /**
     * Method: findUserbyId(@PathVariable String id)
     */
    @Test
    public void testFindUserbyId() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: findAllEmployees(@RequestParam Long courseId)
     */
    @Test
    public void testFindAllEmployees() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: main(String[] args)
     */
    @Test
    public void testMain() throws Exception {
//TODO: Test goes here... 
    }


} 
