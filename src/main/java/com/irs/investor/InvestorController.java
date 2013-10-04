package com.irs.investor;

import com.irs.address.PhysicalAddress;
import com.irs.address.PostalAddress;
import com.irs.person.Person;
import com.irs.person.PersonService;
import com.irs.person.Title;
import com.irs.util.Constants;
import com.irs.util.InvestorUtil;
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
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Kenneth.Maposa
 */
@Controller
@RequestMapping("/admin/investor")
public class InvestorController {

    private static final Log log = LogFactory.getLog(InvestorController.class.getName());
    private InvestorService investorService;
    private PersonService personService;
    private MessageUtil messageUtil = new MessageUtil();
    private InvestorUtil investorUtil = new InvestorUtil();

    @Autowired
    public void setInvestorService(InvestorService investorService) {
        this.investorService = investorService;
    }

    @Autowired
    public void setPersonService(PersonService personService) {
        this.personService = personService;
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
    public ModelAndView viewInvestors(ModelMap model, HttpServletRequest request,
            HttpServletResponse response) {
        log.info("View All Investors");
        List<Investor> investors = investorService.getInvestors();
        String message = request.getParameter("message");
        log.info("\n\n\n\n\n\nREQUEST MESSAGE: " + message + "\n\n\n\n\n\n");
        model = messageUtil.checkMessage(message, model);

        model.put("investors", investors);

        return new ModelAndView("investor/index", model);
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
    @RequestMapping(value = "/addinvestor", method = RequestMethod.GET)
    public ModelAndView addInvestor(ModelMap model, HttpServletRequest request,
            HttpServletResponse response) {
        log.info("Add a new Investor");
        // get a list of titles
        List<Title> titleList = personService.getTitles();
        log.debug("*********\n\n\n\n\n\n\n\n\nThe title list size is: " + titleList.size());
        log.info("*********\n\n\n\n\n\n\n\n\n*********");
        model.put("titleList", titleList);
        model.put("investor", new Investor());

        return new ModelAndView("investor/addinvestor", model);
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
    @RequestMapping(value = "/addinvestor", method = RequestMethod.POST)
    public ModelAndView saveInvestor(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        log.info("-- Saving an Investor -- ");
        // create an investor object
        String message = "";
        Investor investor = new Investor();
        Person person = new Person();
        PhysicalAddress physicalAddress = new PhysicalAddress();
        PostalAddress postalAddress = new PostalAddress();
        Set<PhysicalAddress> physical = new HashSet<PhysicalAddress>();
        Set<PostalAddress> postal = new HashSet<PostalAddress>();
        Set<Person> personSet = new HashSet<Person>();

        try {
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
            person.setEmailAddress(personEmailAddress);
            person.setFirstname(firstName);
            person.setGender(gender);
            person.setTitle(title);
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

        String description = request.getParameter("description");
        String contactNumber = request.getParameter("contactnumber");
        String investorEmailAddress = request.getParameter("investoremailaddress");

        // set investor attributes
        investor.setInvestorDescription(description);
        investor.setContactNumber(contactNumber);
        investor.setEmailAddress(investorEmailAddress);

        //join
        investor.setPhysicalAddress(physical);
        investor.setPostalAddress(postal);
        investor.setPerson(personSet);
        person.setInvestor(investor);
        physicalAddress.setInvestor(investor);
        postalAddress.setInvestor(investor);

        log.info(investor.toString());

        int id = -1;
        try {
            id = investorService.addInvestor(investor);
            message = Constants.INVESTOR_ADDED;
            model.put("message", message);
        } catch (Exception ex) {
            log.debug(ex);
        }
        String redirectUrl = "redirect:/admin/investor/viewinvestor/" + id;

        return new ModelAndView(redirectUrl, model);


        // save investor attributes in database
        //Integer newInvestorId = investorService.addInvestor(investor);
        //log.info("The investor id is: " + newInvestorId);
        //String redirectUrl = "redirect:/admin/investor/viewinvestor/" + newInvestorId;

        //return new ModelAndView(redirectUrl, model);
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
    @RequestMapping(value = "/editinvestor/{investorId}", method = RequestMethod.GET)
    public ModelAndView editInvestor(@PathVariable Integer investorId, ModelMap model, HttpServletRequest request,
            HttpServletResponse response) {
        log.info("Edit an investor");
        Investor investor = investorService.getInvestor(investorId);
        Set<PhysicalAddress> physicalAddressSet = new HashSet<PhysicalAddress>();
        Set<PostalAddress> postalAddressSet = new HashSet<PostalAddress>();
        Set<Person> personSet = new HashSet<Person>();

        physicalAddressSet = investor.getPhysicalAddress();
        postalAddressSet = investor.getPostalAddress();
        personSet = investor.getPerson();

        PhysicalAddress physicalAddress = null;
        PostalAddress postalAddress = null;
        Person person = null;

        for (Iterator<PhysicalAddress> it = physicalAddressSet.iterator(); it.hasNext();) {
            physicalAddress = it.next();
        }
        for (Iterator<PostalAddress> it = postalAddressSet.iterator(); it.hasNext();) {
            postalAddress = it.next();
        }
        for (Iterator<Person> it = personSet.iterator(); it.hasNext();) {
            person = it.next();
        }

        List<Title> titleList = personService.getTitles();

        log.info(investor.toString());
        model.put("investor", investor);
        model.put("physicaladdress", physicalAddress);
        model.put("postaladdress", postalAddress);
        model.put("person", person);
        model.put("titleList", titleList);

        return new ModelAndView("investor/editinvestor", model);
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
    @RequestMapping(value = "/editinvestor/{investorId}", method = RequestMethod.POST)
    public ModelAndView updateInvestor(ModelMap model, @PathVariable int investorId, HttpServletRequest request, HttpServletResponse response) {
        String message = "";
        investorUtil.setPersonService(personService);
        Investor investor = investorUtil.getInvestorDetails(model, request, investorId);

        investorService.editInvestor(investor);
        message = Constants.INVESTOR_EDITED;
        model.put("message", message);

        return new ModelAndView("redirect:/admin/investor/viewinvestor/" + investorId, model);
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
    @RequestMapping(value = "/deleteinvestor/{id}", method = RequestMethod.GET)
    public ModelAndView deleteInvestor(@PathVariable Integer id, ModelMap model, HttpServletRequest request,
            HttpServletResponse response) {
        String message = "";
        log.info("Deleting an investor");

        boolean status = investorService.deleteInvestor(id);
        if (status) {
            log.info("\n\n\n****investor deleted successfully*****\n\n\n");
            message = Constants.INVESTOR_DELETED;
        }

        model.put("message", message);

        return new ModelAndView("redirect:/admin/investor", model);
    }

    @RequestMapping(value = "/viewinvestor/{investorId}", method = RequestMethod.GET)
    public ModelAndView viewInvestor(@PathVariable Integer investorId, ModelMap model, HttpServletRequest request,
            HttpServletResponse response) {

        String message = request.getParameter("message");
        model = messageUtil.checkMessage(message, model);

        Investor investor = investorService.getInvestor(investorId);
        Set<PhysicalAddress> physicalAddressSet = investor.getPhysicalAddress();
        Set<PostalAddress> postalAddressSet = investor.getPostalAddress();
        Set<Person> personSet = investor.getPerson();

        PhysicalAddress physicalAddress = null;
        PostalAddress postalAddress = null;
        Person person = null;

        for (PhysicalAddress physAdd : physicalAddressSet) {
            physicalAddress = physAdd;
        }
        for (PostalAddress postAddr : postalAddressSet) {
            postalAddress = postAddr;
        }
        for (Person pers : personSet) {
            person = pers;
        }

        model.put("investor", investor);
        model.put("physicaladdress", physicalAddress);
        model.put("postaladdress", postalAddress);
        model.put("person", person);

        return new ModelAndView("investor/viewinvestor", model);
    }
}
