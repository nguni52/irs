package com.irs.test.client;

import com.irs.person.Person;
import com.irs.person.PersonService;
import com.irs.person.Title;
import com.irs.user.Authority;
import com.irs.user.User;
import com.irs.user.UserService;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author nkululekophakela
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/application-db-test-context.xml", "/user-context.xml", "/person-context.xml"})
public class UserTest {

    private static final Log log = LogFactory.getLog(UserTest.class.getName());
    @Autowired
    private UserService userService;
    @Autowired
    private PersonService personService;

    @Test
    public void testAddDefaultUser() {
        assertNotNull(userService);
        User user = new User();
        Authority authority = new Authority("admin", "ROLE_ADMIN");
        user.setUsername("admin");
        user.setPassword("irs.2010");
        user.setEnabled(1);
        user.setPasswordExpired(0);

        user.setAuthority(authority);
        authority.setUser(user);

        try {
            userService.addUser(user);
        } catch (MySQLIntegrityConstraintViolationException ex) {
            log.debug("ERROR: ", ex);
        } catch (ConstraintViolationException cve) {
            log.debug("ERROR: ", cve);
        }
    }

    @Test
    public void testAddUser() {
        assertNotNull(userService);

        User testUser = new User();
        Authority authority = new Authority("johndoe", "ROLE_ADMIN");
        Person person = new Person();
        Title title = personService.getTitle(personService.getLatestTitle());

        assertNotNull(title);
        log.info("\n\n\n\n\n\n\n\n*******************Begin testAddUser Test***********************\n\n\n\n\n\n\n\n");
        log.info("ID: " + title.getTitleId());
        log.info("TITLE: " + title.getTitle());
        log.info("\n\n\n\n\n\n\n\n*******************End testAddUser Test***********************\n\n\n\n\n\n\n\n");

        testUser.setUsername("johndoe");
        testUser.setPassword("johnnieboy");
        testUser.setEnabled(1);
        testUser.setPasswordExpired(1);

        // set person attributes
        person.setEmailAddress("johndoe@nguni52.co.za");
        person.setFirstname("John");
        person.setSurname("Doe");
        person.setGender("Male");
        person.setIdentityNumber("1983092223233");
        person.setJobTitle("Drug Smuggler");
        person.setMobileNumber("078-000-0001");
        person.setWorkNumber("011-111-1000");
        person.setUser(testUser);
        person.setTitle(title);
        Set<Person> personSet = new HashSet<Person>();
        personSet.add(person);

        testUser.setAuthority(authority);
        authority.setUser(testUser);
        testUser.setPerson(personSet);

        try {
            int id = userService.addUser(testUser);
            log.info("\n\n\n\n\n\n\n\n*******************ID OF PERSON JUST ADDED IS ***********************\n\n\n\n\n\n\n\n");
            log.info("ID: " + id);
            log.info("\n\n\n\n\n\n\n\n*********************************************************************\n\n\n\n\n\n\n\n");
        } catch (MySQLIntegrityConstraintViolationException ex) {
            log.debug("ERROR: ", ex);
        } catch (ConstraintViolationException cve) {
            log.debug("ERROR: ", cve);
        }
    }

    @Test
    public void testEditUser() {
        log.info("\n\n\n\n\n\n\n\n*******************Begin testEditUser Test***********************\n\n\n\n\n\n\n\n");
        assertNotNull(userService);
        // get the user to edit
        User user = userService.getLatestUser();
        log.info("The latest user info: " + user.toString());

        user.setUsername("nguni52212");
        log.info("The latest user info: " + user.toString());
        Authority authority = user.getAuthority();
        assertNotNull("Authority is null", authority);

        try {
            authority.setUsername(user.getUsername());
            authority.setAuthority("ROLE_IPHONE");
        } catch (NullPointerException npe) {
            log.debug("NPE SON!", npe);
        }
        user.setAuthority(authority);
        user.setEnabled(1);
        authority.setUser(user);
        log.info("The latest user info: " + user.toString());

        // update user and authority
        userService.editUser(user);
        log.info("\n\n\n\n\n\n\n\n*******************End createAccountForPerson Test***********************\n\n\n\n\n\n\n\n");
    }

    //@Test
    public void testGetUsers() {
        assertNotNull(userService);
        // retrieve all the users and print them out
        List<User> users = userService.getUsers();

        log.info("Users: ");
        log.info("\n\n\n\n\n\n***************************");
        for (User user : users) {
            log.info("username: " + user.getUsername());
        }
        log.info("***************************\n\n\n\n\n\n");
    }

    //@Test
    public void testGetUser() {
        assertNotNull(userService);

        User user = userService.getLatestUser();
        log.info("\n\n\n\n\n\n***************************");
        log.info("username: " + user.getUsername());
        Set<Person> personSet = user.getPerson();
        for (Person person : personSet) {
            log.info("Firstname: " + person.getFirstname());
            log.info("Surname: " + person.getSurname());
        }
        log.info("***************************\n\n\n\n\n\n");
    }

    //@Test
    public void testDeleteUser() {
        assertNotNull(userService);
        User user = userService.getLatestUser();
        userService.deleteUser(user.getUserID());
    }

    //@Test
    public void createAccountForPerson() {
        log.info("\n\n\n\n\n\n\n\n*******************Begin createAccountForPerson Test***********************\n\n\n\n\n\n\n\n");

        String username = "petertosh";
        String password = "P@ssw0rd";
        String role = "ROLE_ADMIN";

        User testUser = new User();
        Authority authority = new Authority(username, role);


        testUser.setUsername(username);
        testUser.setPassword(password);
        testUser.setEnabled(1);
        testUser.setAuthority(authority);

        try {
            userService.addUser(testUser);
        } catch (MySQLIntegrityConstraintViolationException ex) {
            log.debug("ERROR: ", ex);
        } catch (ConstraintViolationException cve) {
            log.debug("ERROR: ", cve);
        }

        // we use this function so that we can get the newly created user, and associate them with the person
        testUser = userService.getUserByUsername(username);
        Person person = personService.getPerson(93);
        Set<Person> personSet = new HashSet<Person>();
        personSet.add(person);

        authority.setUser(testUser);
        testUser.setPerson(personSet);
        person.setUser(testUser);
        userService.editUser(testUser);
        log.info("\n\n\n\n\n\n\n\n*******************End createAccountForPerson Test***********************\n\n\n\n\n\n\n\n");
    }
}