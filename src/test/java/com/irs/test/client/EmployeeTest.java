/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.irs.test.client;


import com.irs.employee.Employee;
import com.irs.employee.EmployeeService;
import com.irs.person.Person;
import com.irs.person.PersonService;
import com.irs.person.Title;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.assertNotNull;

/**
 *
 * @author lutendo
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/employee-context.xml", "/person-context.xml", "/application-db-test-context.xml"})
public class EmployeeTest {
    private final static Log log = LogFactory.getLog(EmployeeTest.class.getName());
    
    @Autowired
    private EmployeeService employeeService;
    
    @Autowired
    private PersonService personService;

    @Test
    public void addEmployeeTest() {
        log.info("\n\n\n*************************************\n\n\n");
        log.info("BEGIN ADDEMPLOYEETEST");
        log.info("\n\n\n*************************************\n\n\n");
        // create an employee object
        /*Employee employee = new Employee();
        Person person = new Person();
        employee.setEmployeeNo("A0018874");
        
        // set person attributes
        Title title = personService.getTitle(100);
        person.setEmailAddress("m@nguni52.co.za");
        person.setFirstname("Employee");
        person.setSurname("Test");
        person.setGender("male");
        person.setTitle(title);
        person.setIdentityNumber("1983092223233");
        person.setJobTitle("Employee Manager");
        person.setMobileNumber("078-000-0001");
        person.setWorkNumber("011-111-1000");
        
        assertNotNull(employee);
        assertNotNull(person);
        employee.setPerson(person);
        person.setEmployee(employee);*/
        
        // save employee
        //employeeService.addEmployee(employee);
        log.info("\n\n\n*************************************\n\n\n");
        log.info("BEGIN ADDEMPLOYEETEST");
        log.info("\n\n\n*************************************\n\n\n");
    }
    
    //@Test
    public void editEmployeeTest() {
        assertNotNull(employeeService);
        // need to get an employee
        /*Employee employee = employeeService.getEmployee(2);
        // check that employee exists
        assertNotNull(employee);
        // save the employee
        employeeService.editEmployee(employee);*/
    }
    
    //@Test
    public void viewEmployeesTest() {
        assertNotNull(employeeService);
        /*// need to get all asset managers
        List<Employee> employees = employeeService.getEmployees();
        // check that the above is not null
        assertNotNull(employees);
        
        // list them on the output 
        for(Employee employee: employees) {
            log.info(employee.toString());
        }*/
    }
    
    //@Test
    public void deleteEmployeeTest() {
        assertNotNull(employeeService);
        // delete an asset manager
        
        // get the latest employee
        Integer employeeId = employeeService.getLatestEmployee();
        Employee employee = employeeService.getEmployee(employeeId);
        //personService.deletePerson(employee.getPerson().getPersonId());
        employeeService.deleteEmployee(employeeId.intValue());
    }   
}