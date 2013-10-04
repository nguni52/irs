package com.irs.user;

import com.irs.person.Person;
import com.irs.person.PersonService;
import com.irs.person.Title;
import com.irs.role.Role;
import com.irs.role.RoleService;
import com.irs.util.Constants;
import com.irs.util.MessageUtil;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author nkululekophakela
 */
@Controller
@RequestMapping("/admin/user")
public class UserController {

    private static final Log log = LogFactory.getLog(UserController.class.getName());
    private UserService userService;
    private PersonService personService;
    private RoleService roleService;
    private UserValidator userValidator;
    private MessageUtil messageUtil = new MessageUtil();

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @Autowired
    public void setUserValidator(UserValidator userValidator) {
        this.userValidator = userValidator;
    }

    /*
     * 
     * This method is to view a list of users
     * @param model
     * @param request
     * @param response
     * @access public
     * @return The view for the list of users
     * 
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView viewUsers(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        log.info("View All Users");
        List<User> users = userService.getUsers();
        String message = request.getParameter("message");
        model = messageUtil.checkMessage(message, model);

        model.put("users", users);

        return new ModelAndView("users/index", model);
    }

    @RequestMapping(value = "/adduser", method = RequestMethod.GET)
    public ModelAndView addUser(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        log.info("Add a new user");
        List<Title> titleList = personService.getTitles();
        List<Role> roleList = roleService.getRoles();

        model.put("titleList", titleList);
        model.put("roleList", roleList);
        model.put("user", new User());

        return new ModelAndView("users/adduser", model);
    }

    /*@RequestMapping(value = "/adduser", method = RequestMethod.POST)
     public ModelAndView saveUser(@ModelAttribute("user") User user,
     BindingResult result,
     ModelMap model) {
     log.info("-- Saving a user -- ");
     //log.info("User First Name: " + user.getFirstName());
     //log.info("User Last Name: " + user.getLastName());
        
     userValidator.validate(user, result);
        
     if(result.hasFieldErrors()) {
     List <FieldError> errors = result.getFieldErrors();
            
     log.info(errors.get(0)+"----- \n"+errors.get(1)+"----- \n"+errors.get(2)+"----- \n"+errors.get(3)); 
     log.info("User Validation failed"); 
     return new ModelAndView("users/adduser", model);            
     }
     else {
     userService.addUser(user);
     return new ModelAndView("redirect:/adduser", model);
     }                
     }*/
    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public ModelAndView saveUser(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        String message = "";
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int roleId = Integer.parseInt(request.getParameter("roleid"));
        String personEmailAddress = request.getParameter("personemailaddress");
        String firstName = request.getParameter("firstname");
        String gender = request.getParameter("gender");
        String identityNumber = request.getParameter("identitynumber");
        String jobTitle = request.getParameter("jobtitle");
        String mobileNumber = request.getParameter("mobilenumber");
        String surname = request.getParameter("surname");
        String workNumber = request.getParameter("worknumber");
        int titleId = Integer.parseInt(request.getParameter("titleid"));

        String role = roleService.getRole(roleId).getDescription();

        User testUser = new User();
        Authority authority = new Authority(username, role);
        Person person = new Person();

        Title title = personService.getTitle(titleId);
        testUser.setUsername(username);
        testUser.setPassword(password);
        testUser.setEnabled(1);
        testUser.setPasswordExpired(1);
        // set person attributes
        person.setEmailAddress(personEmailAddress);
        person.setFirstname(firstName);
        person.setGender(gender);
        person.setIdentityNumber(identityNumber);
        person.setJobTitle(jobTitle);
        person.setMobileNumber(mobileNumber);
        person.setSurname(surname);
        person.setWorkNumber(workNumber);
        person.setTitle(title);

        Set<Person> personSet = new HashSet<Person>();
        personSet.add(person);

        testUser.setAuthority(authority);
        testUser.setPerson(personSet);
        authority.setUser(testUser);
        person.setUser(testUser);
        int id = -1;
        try {
            id = userService.addUser(testUser);
            message = Constants.USER_ADDED;
            model.put("message", message);
        } catch (Exception ex) {
            log.debug(ex);
        }
        String redirectUrl = "redirect:/admin/user/viewuser/" + id;

        return new ModelAndView(redirectUrl, model);
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
    @RequestMapping(value = "/edituser/{userId}", method = RequestMethod.GET)
    public ModelAndView editUser(@PathVariable Integer userId, ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        log.info("Edit a user");
        String isProfile = request.getParameter("profile");
        log.info("\n\n\n\n\n\n\n\n\n\n\n\nisProfile: " + isProfile+"\n\n\n\n\n\n\n\n\n\n\n\n");
        if("true".equalsIgnoreCase(isProfile)) {
            model.put("update", "profile.update");
        } else {
            model.put("update", "user.update");
        }
        User user = userService.getUser(userId);
        List<Role> roleList = roleService.getRoles();

        String message = request.getParameter("message");
        model = messageUtil.checkMessage(message, model);

        List<Title> titleList = personService.getTitles();
        model.put("titleList", titleList);

        Set<Person> personSet = new HashSet<Person>();
        personSet = user.getPerson();
        Person person = null;
        /*for (Person person1 : personSet) {
         person = person1;
         }*/
        for (Iterator<Person> it = personSet.iterator(); it.hasNext();) {
            person = it.next();
        }

        model.put("edit_person", person);
        model.put("roleList", roleList);
        model.put("edit_user", user);

        return new ModelAndView("users/edituser", model);
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
    @RequestMapping(value = "/edituser/{userId}", method = RequestMethod.POST)
    public ModelAndView updateUser(ModelMap model, @PathVariable int userId, HttpServletRequest request, HttpServletResponse response) {
        log.info("-- Editing a user -- ");
        String message = "";

        String password = request.getParameter("password");
        int roleId = Integer.parseInt(request.getParameter("roleid"));
        String personEmailAddress = request.getParameter("personemailaddress");
        String firstName = request.getParameter("firstname");
        String gender = request.getParameter("gender");
        String identityNumber = request.getParameter("identitynumber");
        String jobTitle = request.getParameter("jobtitle");
        String mobileNumber = request.getParameter("mobilenumber");
        String surname = request.getParameter("surname");
        String workNumber = request.getParameter("worknumber");
        int titleId = Integer.parseInt(request.getParameter("titleid"));

        String role = roleService.getRole(roleId).getDescription();

        User testUser = userService.getUser(userId);
        String username = testUser.getUsername();

        if (!password.isEmpty()) {
            password = userService.encodePassword(password);
            testUser.setPassword(password);
        }

        Authority authority = userService.getAuthority(username);
        authority.setAuthority(role);
        authority.setUser(testUser);
        testUser.setAuthority(authority);
        userService.editAuthority(authority);

        Person person = new Person();

        testUser.setUsername(username);


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

        Set<Person> personSet = new HashSet<Person>();
        personSet.add(person);

        testUser.setPerson(personSet);
        person.setUser(testUser);

        userService.editUser(testUser);

        message = Constants.USER_EDITED;
        model.put("message", message);
        return new ModelAndView("redirect:/admin/user/viewuser/{userId}", model);
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
    @RequestMapping(value = "/deleteuser/{id}", method = RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable Integer id, ModelMap model, HttpServletRequest request,
            HttpServletResponse response) {
        log.info("Deleting a user");
        String message = "";
        boolean status = userService.deleteUser(id);
        if (status) {
            log.info("\n\n\n****user deleted successfully*****\n\n\n");
            message = Constants.USER_DELETED;//"user deleted successfuly";
        }
        model.put("message", message);
        log.info("We have finished deleting a user");

        return new ModelAndView("redirect:/admin/user", model);
    }

    /*
     * 
     * This method is to view a user
     * @param model
     * @param request
     * @param response
     * @access public
     * @return The view for the list of users
     * 
     */
    @RequestMapping(value = "/viewuser/{id}", method = RequestMethod.GET)
    public ModelAndView viewUser(@PathVariable Integer id, ModelMap model, HttpServletRequest request,
            HttpServletResponse response) {
        log.info("View a user");
        if (id == -1) {
            model = messageUtil.getFailedUserAdd(model);
        } else {
            String message = request.getParameter("message");
            model = messageUtil.checkMessage(message, model);
            User user = userService.getUser(id);

            Set<Person> personSet = new HashSet<Person>();
            personSet = user.getPerson();
            Person person = null;

            for (Person person1 : personSet) {
                person = person1;
            }

            model.put("edit_person", person);
            model.put("edit_user", user);
        }
        return new ModelAndView("users/viewuser", model);
    }

    @RequestMapping(value = "/viewmyprofile", method = RequestMethod.GET)
    public ModelAndView viewMyProfile(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        log.info("View a user");
        //get the currently logged in user
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = null;
        if (principal instanceof UserDetails) {
            userDetails = (UserDetails) principal;
        }
        String username = userDetails.getUsername();

        User user = userService.getUserByUsername(username);


        String message = request.getParameter("message");
        model = messageUtil.checkMessage(message, model);

        Set<Person> personSet = new HashSet<Person>();
        personSet = user.getPerson();
        Person person = null;

        for (Person person1 : personSet) {
            person = person1;
        }

        model.put("current_person", person);
        model.put("current_user", user);

        return new ModelAndView("users/viewmyprofile", model);
    }

    @RequestMapping(value = "/createaccountforperson/{personId}", method = RequestMethod.GET)
    public ModelAndView createAccountForPerson(@PathVariable Integer personId, ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        Person person = personService.getPerson(personId);
        model.put("person", person);

        return new ModelAndView("users/viewperson", model);
    }
    /*@RequestMapping(value = "/createaccountforperson/{personId}", method = RequestMethod.POST)
     public ModelAndView createAccountForPerson(ModelMap model, @PathVariable Integer personId, HttpServletRequest request, HttpServletResponse response)
     {
     String username = request.getParameter("username");
     String password = request.getParameter("password");
     String role = request.getParameter("role");
        
     User testUser = new User();
     Authority authority = new Authority(username, role);
     Person person = personService.getPersson(personId);
        
     testUser.setusername(username);
     testUser.setPassword(password);
     testUser.setEnabled(1);
        
     Set<Person> personSet = new HashSet<Person>();
     personSet.add(person);

     testUser.setAuthority(authority);
     testUser.setPerson(personSet);
     authority.setUser(testUser);
     person.setUser(testUser);
        
     try {
     userService.addUser(testUser);
     } catch(Exception ex) {
     log.debug(ex);
     }
     return new ModelAndView("redirect:/admin/user", model);
     }*/
}
