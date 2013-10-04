package com.irs.test.client;

import com.irs.address.PhysicalAddress;
import com.irs.address.PostalAddress;
import com.irs.assetmanager.AssetManager;
import com.irs.assetmanager.AssetManagerService;
import com.irs.person.Person;
import com.irs.person.PersonService;
import com.irs.person.Title;
import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.util.HashSet;
import org.hibernate.exception.ConstraintViolationException;

import static org.junit.Assert.assertNotNull;

/**
 *
 * @author nkululekophakela
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/assetmanager-context.xml", "/person-context.xml", "/application-db-test-context.xml"})
public class AssetManagerTest {
    private final static Log log = LogFactory.getLog(AssetManagerTest.class.getName());
    @Autowired
    private AssetManagerService assetManagerService;
    @Autowired
    private PersonService personService;

    //@Test
    public void addAssetManagerTest() {
        // create an asset manager object
        AssetManager assetManager = new AssetManager();
        Person person = new Person();
        PhysicalAddress physicalAddress = new PhysicalAddress();
        PostalAddress postalAddress = new PostalAddress();

        // set asset manager attributes
        assetManager.setAssetManagerDescription("Allan Gray");
        assetManager.setContactNumber("0731234567");
        assetManager.setEmailAddress("mk@gmail.com");

        //int assetManagerId = assetManagerService.
        Title title = personService.getTitle(100);

        // set person attributes
        person.setTitle(title);
        person.setEmailAddress("m@nguni52.co.za");
        person.setFirstname("Asset");
        person.setGender("male");
        person.setIdentityNumber("1983092223233");
        person.setJobTitle("Accountant");
        person.setMobileNumber("078-000-0001");
        person.setSurname("Manager");
        person.setWorkNumber("011-111-1000");

        //set physical address attributes
        physicalAddress.setCity("Sandton");
        physicalAddress.setComplexName("Investec Center");
        physicalAddress.setPostalCode(2308);
        physicalAddress.setStatus(1);
        physicalAddress.setStreetNumber(24);
        physicalAddress.setStreetName("My Road");
        physicalAddress.setSuburb("Sandton");
        physicalAddress.setUnitNumber(12);

        Set<PhysicalAddress> physical = new HashSet<PhysicalAddress>();
        physical.add(physicalAddress);

        //set postal address attributes
        postalAddress.setNumber(33);
        postalAddress.setPostalCode(204);
        postalAddress.setStatus(1);
        postalAddress.setSuburb("Sandton");

        Set<PostalAddress> postal = new HashSet<PostalAddress>();
        postal.add(postalAddress);

        Set<Person> personSet = new HashSet<Person>();
        personSet.add(person);

        //join
        assetManager.setPhysicalAddress(physical);
        assetManager.setPostalAddress(postal);
        assetManager.setPerson(personSet);
        person.setAssetManager(assetManager);
        physicalAddress.setAssetManager(assetManager);
        postalAddress.setAssetManager(assetManager);

        assertNotNull(assetManager);
        log.info(assetManager.toString());
        // save asset manager attributes in database                
        try {
            int id = assetManagerService.addAssetManager(assetManager);
            log.info("\n\n\n\n\n\n\n\n*******************ID OF PERSON JUST ADDED IS ***********************\n\n\n\n\n\n\n\n");
            log.info("ID: " + id);
            log.info("\n\n\n\n\n\n\n\n*********************************************************************\n\n\n\n\n\n\n\n");
        } catch (MySQLIntegrityConstraintViolationException ex) {
            log.debug("ERROR: ", ex);
        } catch (ConstraintViolationException cve) {
            log.debug("ERROR: ", cve);
        }
    }

    //@Test 
    public void editAssetManagerPhysicalAddressTest() {
        assertNotNull(assetManagerService);
        AssetManager assetManager = assetManagerService.getAssetManager(10);
        PhysicalAddress physicalAddress = new PhysicalAddress();
        log.info("********************************\n\n\n\n\n");
        log.info("ASSET MANAGER INFORMATION");
        log.info(assetManager.getAssetManagerDescription() + ":::" + assetManager.getEmailAddress() + "::::" + assetManager.getContactNumber());
        log.info("********************************\n\n\n\n\n");

        //set physical address attributes
        physicalAddress.setCity("Cape Town");
        physicalAddress.setComplexName("Allan Gray Building");
        physicalAddress.setPostalCode(8001);
        physicalAddress.setStatus(1);
        physicalAddress.setStreetNumber(24);
        physicalAddress.setStreetName("Zille Road");
        physicalAddress.setSuburb("Pinelands");
        physicalAddress.setUnitNumber(12);

        Set<PhysicalAddress> physical = new HashSet<PhysicalAddress>();
        physical.add(physicalAddress);
        assetManager.setPhysicalAddress(physical);
        physicalAddress.setAssetManager(assetManager);
        assetManagerService.editAssetManager(assetManager);
    }

    //@Test 
    public void editAssetManagerPostalAddressTest() {
        assertNotNull(assetManagerService);
        AssetManager assetManager = assetManagerService.getAssetManager(6);
        PostalAddress postalAddress = new PostalAddress();
        log.info("********************************\n\n\n\n\n");
        log.info("ASSET MANAGER INFORMATION");
        log.info(assetManager.getAssetManagerDescription() + ":::" + assetManager.getEmailAddress() + "::::" + assetManager.getContactNumber());
        log.info("********************************\n\n\n\n\n");

        //set postal address attributes
        postalAddress.setNumber(33);
        postalAddress.setPostalCode(204);
        postalAddress.setStatus(1);
        postalAddress.setSuburb("Pinelands");

        Set<PostalAddress> postal = new HashSet<PostalAddress>();
        postal.add(postalAddress);
        assetManager.setPostalAddress(postal);
        postalAddress.setAssetManager(assetManager);
        assetManagerService.editAssetManager(assetManager);
    }

    //@Test 
    public void editAssetManagerContactPersonTest() {
        assertNotNull(assetManagerService);
        AssetManager assetManager = assetManagerService.getAssetManager(7);
        Person person = new Person();
        log.info("********************************\n\n\n\n\n");
        log.info("ASSET MANAGER INFORMATION");
        log.info(assetManager.getAssetManagerDescription() + ":::" + assetManager.getEmailAddress() + "::::" + assetManager.getContactNumber());
        log.info("********************************\n\n\n\n\n");

        // set person attributes
        person.setEmailAddress("bm@allangray.co.za");
        person.setFirstname("Bujhar");
        person.setGender("male");
        person.setIdentityNumber("1983092223233");
        person.setJobTitle("Software Engineer");
        person.setMobileNumber("078-000-0001");
        person.setSurname("Mqolweni");
        person.setWorkNumber("011-111-1000");

        Title title = personService.getTitle(personService.getLatestTitle());

        Set<Person> contact = new HashSet<Person>();
        contact.add(person);
        assetManager.setPerson(contact);
        person.setAssetManager(assetManager);
        person.setTitle(title);
        assetManagerService.editAssetManager(assetManager);
    }

    //@Test
    public void editAssetManagerTest() {
        assertNotNull(assetManagerService);
        // need to get an assetManager
        AssetManager assetManager = assetManagerService.getAssetManager(8);
        // check that assetManager exists
        assertNotNull(assetManager);
        assetManager.setAssetManagerDescription("Test");
        assetManager.setContactNumber("20030815");
        // save the assetManager
        assetManagerService.editAssetManager(assetManager);
    }

    //@Test
    public void viewAssetManagersTest() {
        assertNotNull(assetManagerService);
        // need to get all asset managers
        List<AssetManager> assetManagers = assetManagerService.getAssetManagers();
        // check that the above is not null
        assertNotNull(assetManagers);

        // list them on the output 
        for (AssetManager assetManager : assetManagers) {
            log.info(assetManager.toString());
        }
    }

    @Test
    public void deleteAssetManagerTest() {
        assertNotNull(assetManagerService);
        // delete an asset manager
        //assetManagerService.deleteAssetManager(9);
    }
}
