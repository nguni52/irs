package com.irs.trusteerole;

import java.util.List;
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
 * @author 10014562
 */
@Controller
@RequestMapping("/admin/trusteerole")
public class TrusteeRoleController {
    private Log log = LogFactory.getLog(TrusteeRoleController.class.getName());
    private TrusteeRoleService trusteeRoleService;
    
    @Autowired
    public void setTrusteeRoleService(TrusteeRoleService trusteeRoleService) {
        this.trusteeRoleService = trusteeRoleService;
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(ModelMap model) {
        
        model.addAttribute("trusteerole", new TrusteeRole());
        
        return new ModelAndView("trusteerole/index", model);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView addTrusteeRole(@ModelAttribute("trustee") TrusteeRole trusteeRole, ModelMap model) {
        trusteeRoleService.addTrusteeRole(trusteeRole);        
        
        return new ModelAndView("redirect:/trusteerole", model);
    }
    
      @RequestMapping(value = "/viewtrusteeroles", method = RequestMethod.GET)
    public ModelAndView viewTrusteeRoles(ModelMap model, HttpServletRequest request,
            HttpServletResponse response) {
        log.info("View All Users");
       List<TrusteeRole> trusteeRoles = trusteeRoleService.getTrusteeRoles();
        
        model.put("trusteeRoles", trusteeRoles);
        
        return new ModelAndView("trusteerole/viewtrusteerole", model);
    }
    
   /*
    @RequestMapping(value="/viewtrusteeroles", method = RequestMethod.GET)
    public ModelAndView viewTrusteeRoles(ModelMap model) {
        
        log.info("view trusteeroles");
        List<TrusteeRole> trusteeroles = trusteeRoleService.getTrusteeRoles();
        
        for(TrusteeRole trusteeRole: trusteeroles) {
            log.info("trusterole: " + trusteeRole.getTrusteeRoleDescription() + "::" + trusteeRole.getTrusteeRoleID());
        }
        model.put("trusteeroles", trusteeroles);
        
        return new ModelAndView("trusteerole/viewtrusteerole", model);
    }
    
    */
    
    
     /*
     * 
     * This method gets the trusteerole to be edited based on the id
     * @param model
     * @param request
     * @param response
     * @access public
     * @return The view trusteerole to be edited
     * 
     */
    @RequestMapping(value = "/edittrusteerole/{id}", method = RequestMethod.GET)
    public ModelAndView editTrusteeRole(@PathVariable Integer id, ModelMap model, HttpServletRequest request,
            HttpServletResponse response) {
        log.info("Edit a trustee");
        TrusteeRole trustee = trusteeRoleService.getTrusteeRole(id);
        
        model.addAttribute("trusteerole", trustee);    
        
        return new ModelAndView("trusteerole/edittrusteerole", model);
    }    

         /*
     * 
     * This method gets the trusteerole to be edited based on the id
     * @param model
     * @param request
     * @param response
     * @access public
     * @return The view trusteerole to be edited
     * 
     */
    @RequestMapping(value = "/edittrusteerole/{id}", method = RequestMethod.POST)
    public ModelAndView saveTrusteeRole(@ModelAttribute("trusteerole") TrusteeRole trusteeRole,
            /*BindingResult result,*/
            ModelMap model) {
        log.info("-- Saving a trustee role -- ");
        
        trusteeRoleService.editTrusteeRole(trusteeRole);
        
        return new ModelAndView("redirect:/trusteerole/viewtrusteeroles", model);
   
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
    @RequestMapping(value = "/deletetrusteerole/{id}", method = RequestMethod.GET)
    public ModelAndView deleteTrusteeRole(@PathVariable Integer id, ModelMap model, HttpServletRequest request,
            HttpServletResponse response) {
        log.info("Deleting a trusteerole");
        boolean status = trusteeRoleService.deleteTrusteeRole(id);
        model.put("status", status);
        log.info("We have finished deleting a trusteerole");
        
       return new ModelAndView("redirect:/trusteerole/viewtrusteeroles", model);
    }
    
}
