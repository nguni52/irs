package com.irs.test.client;

import com.irs.address.PhysicalAddress;
import com.irs.address.PostalAddress;
import com.irs.investor.Investor;
import com.irs.investor.InvestorService;
import com.irs.person.Person;
import com.irs.person.PersonService;
import com.irs.person.Title;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

/**
 *
 * @author bmqolweni
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/investor-context.xml", "/person-context.xml", "/application-db-test-context.xml"})
public class InvestorTest {
    private static final Log log = LogFactory.getLog(InvestorTest.class.getName());
    
    @Autowired
    private InvestorService investorService;
    
    @Autowired
    private PersonService personService;

    @Test
    public void testAddInvestor() {
        // create an investor
        Investor investor = new Investor();
        Person person = new Person();
        PhysicalAddress physicalAddress = new PhysicalAddress();
        PostalAddress postalAddress = new PostalAddress();
        
        // set investor attributes
        investor.setInvestorDescription("LG");
        investor.setContactNumber("0841113999");
        investor.setEmailAddress("info@lg.biz");
        
        // set title attributes
        Title title = personService.getTitle(personService.getLatestTitle());
        
        // set person attributes
        person.setTitle(title);
        person.setEmailAddress("info@lg.biz");
        person.setFirstname("LG Investor");
        person.setGender("male");
        person.setIdentityNumber("1983092223233");
        person.setJobTitle("Chief Executive Investor");
        person.setMobileNumber("078-110-0001");
        person.setSurname("Light");
        person.setWorkNumber("011-111-1000");
        
        //set physical address attributes
        physicalAddress.setCity("Sandton");
        physicalAddress.setComplexName("IAC Building");
        physicalAddress.setPostalCode(2308);
        physicalAddress.setStatus(1);
        physicalAddress.setStreetNumber(24);
        physicalAddress.setStreetName("Vovas Road");
        physicalAddress.setSuburb("Sandton");
        physicalAddress.setUnitNumber(12);
        
        Set<PhysicalAddress> physical = new HashSet<PhysicalAddress>();
        physical.add(physicalAddress);
        
        //set postal address attributes
        postalAddress.setNumber(55);
        postalAddress.setPostalCode(204);
        postalAddress.setStatus(1);
        postalAddress.setSuburb("Sandton");
        
        Set<PostalAddress> postal = new HashSet<PostalAddress>();
        postal.add(postalAddress);
        
        Set<Person> personSet = new HashSet<Person>();
        personSet.add(person);
        
        //join
        investor.setPerson(personSet);
        investor.setPhysicalAddress(physical);
        investor.setPostalAddress(postal);
        person.setInvestor(investor);
        physicalAddress.setInvestor(investor);
        postalAddress.setInvestor(investor);
                
        assertNotNull(investor);
        log.info(investor.toString());
        // save investor attributes in database
        investorService.addInvestor(investor);
    }
    
    //@Test
    public void editInvestorPostalAddressTest() { 
        assertNotNull(investorService);
        Investor investor = investorService.getLatestInvestor();
        
        log.info("********************************\n\n\n\n\n");
        log.info("INVESTOR INFORMATION");
        log.info(investor.getInvestorDescription() + ":::" + investor.getEmailAddress() + "::::" + investor.getContactNumber());
        log.info("********************************\n\n\n\n\n");
        
        PostalAddress postalAddress = new PostalAddress();
        //set postal address attributes
        postalAddress.setNumber(55);
        postalAddress.setPostalCode(204);
        postalAddress.setStatus(1);
        postalAddress.setSuburb("Sandton");
        
        Set<PostalAddress> postal = new HashSet<PostalAddress>();
        postal.add(postalAddress);
        investor.setPostalAddress(postal);
        postalAddress.setInvestor(investor);
        
        investorService.editInvestor(investor);
    }
    
    //@Test 
    public void editInvestoryPhysicalAddressTest() {
        assertNotNull(investorService);
        Investor investor = investorService.getLatestInvestor();
        PhysicalAddress physicalAddress = new PhysicalAddress();
        log.info("********************************\n\n\n\n\n");
        log.info("INVESTOR INFORMATION");
        log.info(investor.getInvestorDescription() + ":::" + investor.getEmailAddress() + "::::" + investor.getContactNumber());
        log.info("********************************\n\n\n\n\n");
        
        //set physical address attributes
        physicalAddress.setCity("Sandton");
        physicalAddress.setComplexName("IAC Building");
        physicalAddress.setPostalCode(2308);
        physicalAddress.setStatus(1);
        physicalAddress.setStreetNumber(24);
        physicalAddress.setStreetName("Vovas Road");
        physicalAddress.setSuburb("Sandton");
        physicalAddress.setUnitNumber(12);
        
        Set<PhysicalAddress> physical = new HashSet<PhysicalAddress>();
        physical.add(physicalAddress);
        investor.setPhysicalAddress(physical);
        physicalAddress.setInvestor(investor);
        investorService.editInvestor(investor);
    }
}
