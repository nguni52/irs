/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.irs.util;

import com.irs.address.PhysicalAddress;
import com.irs.address.PostalAddress;
import com.irs.investor.Investor;
import com.irs.person.Person;
import com.irs.person.PersonService;
import com.irs.person.Title;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.ui.ModelMap;

/**
 *
 * @author nguni52
 */
public class InvestorUtil {

    private static final Log log = LogFactory.getLog(InvestorUtil.class.getName());
    private PersonService personService;

    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    public Investor getInvestorDetails(ModelMap model, HttpServletRequest request, int investorId) {
        log.info("-- Editing an investor -- ");
        Investor investor = new Investor();
        Person person = new Person();
        PhysicalAddress physicalAddress = new PhysicalAddress();
        PostalAddress postalAddress = new PostalAddress();
        Set<PhysicalAddress> physical = new HashSet<PhysicalAddress>();
        Set<PostalAddress> postal = new HashSet<PostalAddress>();
        Set<Person> personSet = new HashSet<Person>();

        try {
            // get the contact person attributes from view
            String personEmailAddress = request.getParameter("personemailaddress");
            String firstName = request.getParameter("firstname");
            String gender = request.getParameter("gender");
            String identityNumber = request.getParameter("identitynumber");
            String jobTitle = request.getParameter("jobtitle");
            String mobileNumber = request.getParameter("mobilenumber");
            String surname = request.getParameter("surname");
            String workNumber = request.getParameter("worknumber");
            
            int titleId = Integer.parseInt(request.getParameter("titleid"));
            Title title = personService.getTitle(titleId);

            // set person attributes
            person.setTitle(title);
            person.setFirstname(firstName);
            person.setGender(gender);
            person.setEmailAddress(personEmailAddress);
            person.setIdentityNumber(identityNumber);
            person.setJobTitle(jobTitle);
            person.setMobileNumber(mobileNumber);
            person.setSurname(surname);
            person.setWorkNumber(workNumber);
            
            personSet.add(person);
        } catch (Exception ex) {
            log.debug(ex);
        }

        try {
            // ge tthe physical address attributes from view
            String city = request.getParameter("city");
            String complexName = request.getParameter("complexname");
            int physicalAddressCode = Integer.parseInt(request.getParameter("physicaladdresscode"));
            int streetNumber = Integer.parseInt(request.getParameter("streetnumber"));
            String physicalAddressSuburb = request.getParameter("physicaladdresssuburb");
            String streetName = request.getParameter("streetname");
            int unitNumber = Integer.parseInt(request.getParameter("unitnumber"));

            //set physical address attributes
            physicalAddress.setCity(city);
            physicalAddress.setComplexName(complexName);
            physicalAddress.setPostalCode(physicalAddressCode);
            physicalAddress.setStreetNumber(streetNumber);
            physicalAddress.setStreetName(streetName);
            physicalAddress.setSuburb(physicalAddressSuburb);
            physicalAddress.setUnitNumber(unitNumber);

            physical.add(physicalAddress);
        } catch (Exception ex) {
            log.debug(ex);
        }

        try {
            // get the postal address attributes
            int postalAddressNumber = Integer.parseInt(request.getParameter("postaladdressnumber"));
            int postalAddressCode = Integer.parseInt(request.getParameter("postaladdresscode"));
            String postalAddressSuburb = request.getParameter("postaladdresssuburb");
            //set postal address attributes
            postalAddress.setNumber(postalAddressNumber);
            postalAddress.setPostalCode(postalAddressCode);
            postalAddress.setSuburb(postalAddressSuburb);

            postal.add(postalAddress);
        } catch (Exception ex) {
            log.debug(ex);
        }

        // get the investor attributes from view
        String description = request.getParameter("description");
        String contactNumber = request.getParameter("contactnumber");
        String investorEmailAddress = request.getParameter("investoremailaddress");

        // set investor attributes
        investor.setInvestorDescription(description);
        investor.setContactNumber(contactNumber);
        investor.setEmailAddress(investorEmailAddress);
        investor.setInvestorID(investorId);

        //join
        investor.setPhysicalAddress(physical);
        investor.setPostalAddress(postal);
        investor.setPerson(personSet);
        person.setInvestor(investor);
        physicalAddress.setInvestor(investor);
        postalAddress.setInvestor(investor);

        //log.info(investor.toString());

        return investor;
    }
}
