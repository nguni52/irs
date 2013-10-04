package com.irs.test.client;

import com.irs.person.Person;
import com.irs.person.PersonService;
import com.irs.person.Title;
import com.irs.trustee.Trustee;
import com.irs.trustee.TrusteeService;
import java.util.List;
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
 * @author Kenneth.Maposa
*/


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/application-db-test-context.xml", "/trustee-context.xml", "/person-context.xml"})
public class TrusteeTest {

    private static final Log log = LogFactory.getLog(TrusteeTest.class.getName());
    @Autowired
    private TrusteeService trusteeService;
    @Autowired
    private PersonService personService;

    @Test
    public void testAddTrustee() {
        assertNotNull(trusteeService);

        Trustee trustee = new Trustee();
        trustee.setInvestorId(12);
        trustee.setTrusteeRoleId(1);
        trustee.setStatus(1);

        Title title = personService.getTitle(personService.getLatestTitle());

        Person person = new Person();
        person.setEmailAddress("jmata@chelsea.com");
        person.setFirstname("Juan");
        person.setSurname("Mata");
        person.setGender("Male");
        person.setIdentityNumber("1983092223233");
        person.setJobTitle("Chief Architect");
        person.setMobileNumber("078-000-0001");
        person.setSurname("Phakzi");
        person.setWorkNumber("011-111-1000");

        person.setTitle(title);
        person.setTrustee(trustee);
        trustee.setPerson(person);

        trusteeService.addTrustee(trustee);
    }

    @Test
    public void testEditTrustee() {
        Integer maxId = trusteeService.getLatestTrustee();
        Trustee trustee = trusteeService.getTrustee(maxId.intValue());
        trustee.setStatus(0);

        assertNotNull(trusteeService);
        trusteeService.editTrustee(trustee);
    }

    //@Test
    public void testGetTrustee() {
        assertNotNull(trusteeService);
        Integer maxId = trusteeService.getLatestTrustee();
        Trustee trustee = trusteeService.getTrustee(maxId.intValue());
        assertNotNull(trustee);
    }

    //@Test
    public void testGetTrustees() {
        assertNotNull(trusteeService);
        List<Trustee> trustees = trusteeService.getTrustees();
    }

    //@Test
    public void testDeleteTrustee() {
        assertNotNull(trusteeService);
        Integer maxId = trusteeService.getLatestTrustee();
        //trusteeService.deleteTrustee(maxId);
    }
}