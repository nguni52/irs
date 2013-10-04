package com.irs.employee;

import com.irs.person.Person;
import com.irs.person.PersonService;
import com.irs.person.Title;
import com.irs.util.Constants;
import com.irs.util.MessageUtil;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author lutendo
 */
@Controller
@RequestMapping("/admin/employee")
public class EmployeeController {

    private Log log = LogFactory.getLog(EmployeeController.class.getName());
    private EmployeeService employeeService;
    private MessageUtil messageUtil = new MessageUtil();
    private PersonService personService;

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Autowired
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    /*
     * 
     * This method is to view a list of asset managers
     * @param model
     * @param request
     * @param response
     * @access public
     * @return The view for the list of asset managers
     * 
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView viewEmployees(ModelMap model, HttpServletRequest request,
            HttpServletResponse response) {
        log.info("View All Employees");
        List<Employee> employees = employeeService.getEmployees();
        String message = request.getParameter("message");
        log.info("\n\n\n\n\n\nREQUEST MESSAGE: " + message + "\n\n\n\n\n\n");
        model = messageUtil.checkMessage(message, model);
        model.put("employees", employees);

        return new ModelAndView("employee/index", model);
    }

    /*
     * 
     * This method is to create a new trustee
     * @param model
     * @param request
     * @param response
     * @access public
     * @return The view trustee to be created
     * 
     */
    @RequestMapping(value = "/addemployee", method = RequestMethod.GET)
    public ModelAndView addEmployee(ModelMap model, HttpServletRequest request,
            HttpServletResponse response) {
        log.info("Add a new Asset Manager");
        List<Title> titleList = personService.getTitles();

        model.put("titleList", titleList);
        model.put("employee", new Employee());

        return new ModelAndView("employee/addemployee", model);
    }

    /*
     * 
     * This method is to save a new trustee into the DB
     * @param model
     * @param request
     * @param response
     * @access public
     * @return The view trustee to be edited
     * 
     */
    @RequestMapping(value = "/addemployee", method = RequestMethod.POST)
    public ModelAndView saveEmployee(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        log.info("-- Saving an Asset Manager -- ");
        // create an asset manager object
        Employee employee = new Employee();
        Person person = new Person();

        int titleId = Integer.parseInt(request.getParameter("titleid"));
        String personEmailAddress = request.getParameter("personemailaddress");
        String firstName = request.getParameter("firstname");
        String gender = request.getParameter("gender");
        String identityNumber = request.getParameter("identitynumber");
        String jobTitle = request.getParameter("jobtitle");
        String mobileNumber = request.getParameter("mobilenumber");
        String surname = request.getParameter("surname");
        String workNumber = request.getParameter("worknumber");

        String city = request.getParameter("city");
        String complexName = request.getParameter("complexname");
        int streetNumber = Integer.parseInt(request.getParameter("streetnumber"));
        String streetName = request.getParameter("streetname");
        int unitNumber = Integer.parseInt(request.getParameter("unitnumber"));
        String description = request.getParameter("description");
        String employeeNo = request.getParameter("employeenumber");


        Title title = personService.getTitle(titleId);

        // set person attributes
        person.setTitle(title);
        person.setEmailAddress(personEmailAddress);
        person.setFirstname(firstName);
        person.setGender(gender);
        person.setIdentityNumber(identityNumber);
        person.setJobTitle(jobTitle);
        person.setMobileNumber(mobileNumber);
        person.setSurname(surname);
        person.setWorkNumber(workNumber);

        //set employee attributes
        employee.setEmployeeNo(employeeNo);

        //person.setEmployee(employee);
        employee.setPerson(person);

        log.info(employee.toString());

        // save asset manager attributes in database
        employeeService.addEmployee(employee);



        return new ModelAndView("redirect:/admin/employee", model);
    }

    /*
     * 
     * This method gets the user to be edited based on the id
     * @param model
     * @param request
     * @param response
     * @access public
     * @return The view user to be edited
     * 
     */
    @RequestMapping(value = "/editemployee/{employeeId}", method = RequestMethod.GET)
    public ModelAndView editEmployee(@PathVariable Integer employeeId, ModelMap model, HttpServletRequest request,
            HttpServletResponse response) {
        log.info("Edit an employee");
        List<Title> titleList = personService.getTitles();
        model.put("titleList", titleList);
        Employee employee = employeeService.getEmployee(employeeId);
        Person person = employee.getPerson();
        model.put("person", person);
        model.put("employee", employee);

        return new ModelAndView("employee/editemployee", model);
    }

    /*
     * 
     * This method updates the user record (from editUser method) based on the id
     * @param model
     * @param request
     * @param response
     * @access public
     * @return The view user to be edited
     * 
     */
    @RequestMapping(value = "/editemployee/{employeeId}", method = RequestMethod.POST)
    public ModelAndView updateEmployee(ModelMap model, @PathVariable int employeeId, HttpServletRequest request, HttpServletResponse response) {
        log.info("-- Editing an asset manager -- ");

        Employee employee = new Employee();
        Person person = new Person();

        String employeeNo = request.getParameter("employeeNumber");

        // set asset employee attributes

        employee.setEmployeeNo(employeeNo);

        employee.setEmployeeID(employeeId);

        model.put("person", person);
        model.put("employee", employee);

        //Set<Person> personSet = new HashSet<Person>();
        //personSet.add(person);

        //join

        //employee.setPerson(personSet);
        // person.setEmployee(employee);


        log.info(employee.toString());

        employeeService.editEmployee(employee);
        return new ModelAndView("redirect:/admin/employee/viewemployee/{employeeId}", model);
        //return new ModelAndView("redirect:/admin/employee", model);
    }

    /*
     * 
     * This method is to delete a user
     * @param model
     * @param request
     * @param response
     * @access public
     * @return The view for the list of users
     * 
     */
    @RequestMapping(value = "/deleteemployee/{id}", method = RequestMethod.GET)
    public ModelAndView deleteEmployee(@PathVariable Integer id, ModelMap model, HttpServletRequest request,
            HttpServletResponse response) {
        String message = "";
        log.info("Deleting an employee");
        boolean status = employeeService.deleteEmployee(id);
        if (status) {
            log.info("\n\n\n****investor deleted successfully*****\n\n\n");
            message = Constants.EMPLOYEE_DELETED;
        }
        model.put("message", message);
        log.info("We have finished deleting an employee");

        return new ModelAndView("redirect:/admin/employee", model);
    }

    @RequestMapping(value = "/viewemployee/{employeeId}", method = RequestMethod.GET)
    public ModelAndView viewEmployee(@PathVariable Integer employeeId, ModelMap model, HttpServletRequest request,
            HttpServletResponse response) {
        log.info("Edit an asset manager");
        Employee employee = employeeService.getEmployee(employeeId);
        Person person = new Person();
        //Set<Person> personSet = new HashSet<Person>();

        person = employee.getPerson();

        log.info(employee.toString());
        model.put("employee", employee);
        model.put("person", person);

        return new ModelAndView("employee/viewemployee", model);
    }
}
