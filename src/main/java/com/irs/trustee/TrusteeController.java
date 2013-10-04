package com.irs.trustee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
/**
 *
 * @author Kenneth.Maposa
 */

@Controller
@RequestMapping("/admin/trustee")
public class TrusteeController {
    private Log log = LogFactory.getLog(TrusteeController.class.getName());
    private TrusteeService trusteeService;
    
    @Autowired
    public void setTrusteeService(TrusteeService trusteeService) {
        this.trusteeService = trusteeService;
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
    @RequestMapping(value = "/addtrustee", method = RequestMethod.GET)
    public ModelAndView addTrustee(ModelMap model, HttpServletRequest request,
            HttpServletResponse response) {
        log.info("Add a new trustee");
        model.addAttribute("trustee", new Trustee());        
        
        return new ModelAndView("trustee/addtrustee", model);
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
    @RequestMapping(value = "/addtrustee", method = RequestMethod.POST)
    public ModelAndView saveTrustee(@ModelAttribute("trustee") Trustee trustee,
            /*BindingResult result,*/
            ModelMap model) {
        log.info("-- Saving a trustee -- ");
        
        
        trusteeService.addTrustee(trustee);
        
        return new ModelAndView("redirect:/addtrustee", model);
    }
    
    /*
     * 
     * This method gets the trustee to be edited based on the id
     * @param model
     * @param request
     * @param response
     * @access public
     * @return The view trustee to be edited
     * 
     */
    @RequestMapping(value = "/edittrustee/{id}", method = RequestMethod.GET)
    public ModelAndView editUser(@PathVariable Integer id, ModelMap model, HttpServletRequest request,
            HttpServletResponse response) {
        log.info("Edit a trustee");
        Trustee trustee = trusteeService.getTrustee(id);
        
        model.addAttribute("trustee", trustee);    
        
        return new ModelAndView("trustee/edittrustee", model);
    }    

    /*
     * 
     * This method updates the trustee record (from editTrustee method) based on the id
     * @param model
     * @param request
     * @param response
     * @access public
     * @return The view trustee to be edited
     * 
     */
   @RequestMapping(value = "/edittrustee/{id}", method = RequestMethod.POST)
    public ModelAndView updateUser(@ModelAttribute("trustee") Trustee trustee,
            /*BindingResult result,*/
            ModelMap model) {
        log.info("-- updating a trustee -- ");
        
        trusteeService.editTrustee(trustee);
        
        return new ModelAndView("redirect:/index", model);
    }
   
   /*
     * 
     * This method is to view a trustee
     * @param model
     * @param request
     * @param response
     * @access public
     * @return The view for the selected trustee
     * 
     */
    @RequestMapping(value = "/viewtrustee/{id}", method = RequestMethod.GET)
    public ModelAndView viewUser(@PathVariable Integer id, ModelMap model, HttpServletRequest request,
            HttpServletResponse response) {
        log.info("Edit a trustee");
        Trustee trustee = trusteeService.getTrustee(id);
        
        model.addAttribute("trustee", trustee);    
        
        return new ModelAndView("trustee/viewtrustee", model);
    }
    
    /*
     * 
     * This method is to delete a trustee
     * @param model
     * @param request
     * @param response
     * @access public
     * @return The view for the list of users
     * 
     */
    @RequestMapping(value = "/deletetrustee/{id}", method = RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable Integer id, ModelMap model, HttpServletRequest request,
            HttpServletResponse response) {
        log.info("Deleting a trustee");
        boolean status = trusteeService.deleteTrustee(id);
        model.put("status", status);
        log.info("We have finished deleting a user");
        
        return new ModelAndView("redirect:/viewusers", model);
    }
}
