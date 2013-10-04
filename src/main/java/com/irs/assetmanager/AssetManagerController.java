package com.irs.assetmanager;

import com.irs.address.PhysicalAddress;
import com.irs.address.PostalAddress;
import com.irs.person.Person;
import com.irs.person.PersonService;
import com.irs.person.Title;
import com.irs.util.Constants;
import com.irs.util.MessageUtil;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
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
 * @author Kenneth.Maposa
 */
@Controller
@RequestMapping("/admin/assetmanager")
public class AssetManagerController {

    private Log log = LogFactory.getLog(AssetManagerController.class.getName());
    private AssetManagerService assetManagerService;
    private MessageUtil messageUtil = new MessageUtil();
    private PersonService personService;

    @Autowired
    public void setAssetManagerService(AssetManagerService assetManagerService) {
        this.assetManagerService = assetManagerService;
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
    public ModelAndView viewAssetManagers(ModelMap model, HttpServletRequest request,
            HttpServletResponse response) {
        log.info("View All Asset Managers");
        List<AssetManager> assetManagers = assetManagerService.getAssetManagers();
        String message = request.getParameter("message");
        log.info("\n\n\n\n\n\nREQUEST MESSAGE: " + message + "\n\n\n\n\n\n");
        model = messageUtil.checkMessage(message, model);
        model.put("assetmanagers", assetManagers);

        return new ModelAndView("assetmanager/index", model);
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
    @RequestMapping(value = "/addassetmanager", method = RequestMethod.GET)
    public ModelAndView addAssetManager(ModelMap model, HttpServletRequest request,
            HttpServletResponse response) {
        log.info("Add a new Asset Manager");
        List<Title> titleList = personService.getTitles();

        model.put("titleList", titleList);
        model.put("assetmanager", new AssetManager());

        return new ModelAndView("assetmanager/addassetmanager", model);
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
    @RequestMapping(value = "/addassetmanager", method = RequestMethod.POST)
    public ModelAndView saveAssetManager(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        log.info("-- Saving an Asset Manager -- ");
        // create an asset manager object
        String message = "";
        AssetManager assetManager = new AssetManager();
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

        String description = request.getParameter("description");
        String contactNumber = request.getParameter("contactnumber");
        String assetManagerEmailAddress = request.getParameter("assetmanageremailaddress");

        // set asset manager attributes
        assetManager.setAssetManagerDescription(description);
        assetManager.setContactNumber(contactNumber);
        assetManager.setEmailAddress(assetManagerEmailAddress);

        //join       
        assetManager.setPhysicalAddress(physical);
        physicalAddress.setAssetManager(assetManager);

        assetManager.setPostalAddress(postal);
        postalAddress.setAssetManager(assetManager);

        assetManager.setPerson(personSet);
        person.setAssetManager(assetManager);

        log.info(assetManager.toString());

        // save asset manager attributes in database
        //assetManagerService.addAssetManager(assetManager);
        int id = -1;
        try {
            id = assetManagerService.addAssetManager(assetManager);
            message = Constants.ASSETMANAGER_ADDED;
            model.put("message", message);
        } catch (Exception ex) {
            log.debug(ex);
        }
        String redirectUrl = "redirect:/admin/assetmanager/viewassetmanager/" + id;

        return new ModelAndView(redirectUrl, model);

        //return new ModelAndView("redirect:/admin/assetmanager", model);
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
    @RequestMapping(value = "/editassetmanager/{assetManagerId}", method = RequestMethod.GET)
    public ModelAndView editAssetManager(@PathVariable Integer assetManagerId, ModelMap model, HttpServletRequest request,
            HttpServletResponse response) {
        log.info("Edit an asset manager");
        List<Title> titleList = personService.getTitles();
        model.put("titleList", titleList);
        AssetManager assetManager = assetManagerService.getAssetManager(assetManagerId);
        Set<PhysicalAddress> physicalAddressSet = new HashSet<PhysicalAddress>();
        Set<PostalAddress> postalAddressSet = new HashSet<PostalAddress>();
        Set<Person> personSet = new HashSet<Person>();

        physicalAddressSet = assetManager.getPhysicalAddress();
        postalAddressSet = assetManager.getPostalAddress();
        personSet = assetManager.getPerson();

        PhysicalAddress physicalAddress = null;
        PostalAddress postalAddress = null;
        Person person = null;

        for (PhysicalAddress physicalAddress1 : physicalAddressSet) {
            physicalAddress = physicalAddress1;
        }
        for (PostalAddress postalAddress1 : postalAddressSet) {
            postalAddress = postalAddress1;
        }
        for (Person person1 : personSet) {
            person = person1;
        }

        log.info(assetManager.toString());
        model.put("assetmanager", assetManager);
        model.put("physicaladdress", physicalAddress);
        model.put("postaladdress", postalAddress);
        model.put("person", person);

        return new ModelAndView("assetmanager/editassetmanager", model);
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
    @RequestMapping(value = "/editassetmanager/{assetManagerId}", method = RequestMethod.POST)
    public ModelAndView updateAssetManager(ModelMap model, @PathVariable int assetManagerId, HttpServletRequest request, HttpServletResponse response) {
        log.info("-- Editing an asset manager -- ");

        String message = "";
        AssetManager assetManager = assetManagerService.getAssetManager(assetManagerId);
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

        String description = request.getParameter("description");
        String contactNumber = request.getParameter("contactnumber");
        String assetManagerEmailAddress = request.getParameter("assetmanageremailaddress");

        // set asset manager attributes
        assetManager.setAssetManagerDescription(description);
        assetManager.setContactNumber(contactNumber);
        assetManager.setEmailAddress(assetManagerEmailAddress);

        //join       
        assetManager.setPhysicalAddress(physical);
        physicalAddress.setAssetManager(assetManager);

        assetManager.setPostalAddress(postal);
        postalAddress.setAssetManager(assetManager);

        assetManager.setPerson(personSet);
        person.setAssetManager(assetManager);


        log.info(assetManager.toString());

        assetManagerService.editAssetManager(assetManager);
        message = Constants.ASSETMANAGER_EDITED;
        model.put("message", message);
        return new ModelAndView("redirect:/admin/assetmanager/viewassetmanager/{assetManagerId}", model);
        //return new ModelAndView("redirect:/admin/assetmanager", model);
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
    @RequestMapping(value = "/deleteassetmanager/{id}", method = RequestMethod.GET)
    public ModelAndView deleteAssetManager(@PathVariable Integer id, ModelMap model, HttpServletRequest request,
            HttpServletResponse response) {
        String message = "";
        log.info("Deleting an asset manager");
        boolean status = assetManagerService.deleteAssetManager(id);
        if (status) {
            log.info("\n\n\n****investor deleted successfully*****\n\n\n");
            message = Constants.ASSETMANAGER_DELETED;
        }
        model.put("message", message);
        log.info("We have finished deleting an assetmanager");

        return new ModelAndView("redirect:/admin/assetmanager", model);
    }

    @RequestMapping(value = "/viewassetmanager/{assetManagerId}", method = RequestMethod.GET)
    public ModelAndView viewAssetManager(@PathVariable Integer assetManagerId, ModelMap model, HttpServletRequest request,
            HttpServletResponse response) {
        log.info("Edit an asset manager");

        String message = request.getParameter("message");
        model = messageUtil.checkMessage(message, model);
        
        AssetManager assetManager = assetManagerService.getAssetManager(assetManagerId);
        Set<PhysicalAddress> physicalAddressSet = new HashSet<PhysicalAddress>();
        Set<PostalAddress> postalAddressSet = new HashSet<PostalAddress>();
        Set<Person> personSet = new HashSet<Person>();

        physicalAddressSet = assetManager.getPhysicalAddress();
        postalAddressSet = assetManager.getPostalAddress();
        personSet = assetManager.getPerson();

        PhysicalAddress physicalAddress = null;
        PostalAddress postalAddress = null;
        Person person = null;

        for (PhysicalAddress physicalAddress1 : physicalAddressSet) {
            physicalAddress = physicalAddress1;
        }
        for (PostalAddress postalAddress1 : postalAddressSet) {
            postalAddress = postalAddress1;
        }
        for (Person person1 : personSet) {
            person = person1;
        }

        log.info(assetManager.toString());
        model.put("assetmanager", assetManager);
        model.put("physicaladdress", physicalAddress);
        model.put("postaladdress", postalAddress);
        model.put("person", person);

        return new ModelAndView("assetmanager/viewassetmanager", model);
    }
}
