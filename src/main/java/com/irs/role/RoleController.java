/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.irs.role;

import com.irs.util.Constants;
import com.irs.util.MessageUtil;
import java.util.List;
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
@RequestMapping("/admin/role")
public class RoleController {
    
    private static final Log log = LogFactory.getLog(RoleController.class.getName());
    private MessageUtil messageUtil = new MessageUtil();
    private RoleService roleService;

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView viewRoles(ModelMap model, HttpServletRequest request, HttpServletResponse response)
    {
        List<Role> roleList = roleService.getRoles();
        model.put("roleList", roleList);
        
        return new ModelAndView("roles/index", model);
    }
    
    @RequestMapping(value = "/addrole", method = RequestMethod.GET)
    public ModelAndView addRole(ModelMap model, HttpServletRequest request, HttpServletResponse response){
        
        model.put("role", new Role());
        return new ModelAndView("roles/addrole", model);
    }
    
    @RequestMapping(value = "/addrole", method = RequestMethod.POST)
    public ModelAndView saveRole(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        int id = -1;
        Role role = new Role();
        String roleDescription = request.getParameter("role_description");
        role.setDescription(roleDescription);
        roleService.save(role);
        
        String redirectUrl = "redirect:/admin/role/viewrole/" + id;
        return new ModelAndView(redirectUrl, model);
    }
    
    @RequestMapping(value = "/editrole/{roleId}", method = RequestMethod.GET)
    public ModelAndView editRole(@PathVariable Integer roleId, ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        
        Role role = roleService.getRole(new Integer(roleId));
        model.put("role",role);
        return new ModelAndView("roles/editrole", model);
    }
    
    @RequestMapping(value = "/editrole/{roleId}", method = RequestMethod.POST)
    public ModelAndView updateRole(ModelMap model, @PathVariable int roleId, HttpServletRequest request, HttpServletResponse response) {
        String roleDescription = request.getParameter("role_description");
        Role role = roleService.getRole(roleId);
        role.setDescription(roleDescription);
        roleService.editRole(role);
        
        return new ModelAndView("redirect:/admin/role/viewrole/{roleId}", model);
    }
    
    @RequestMapping(value = "/deleterole/{id}", method = RequestMethod.GET)
    public ModelAndView deleteRole(@PathVariable Integer id, ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        String message = "";
        boolean status = roleService.deleteRole(id);
        if (status) {
            log.info("\n\n\n****role deleted successfully*****\n\n\n");
            message = Constants.USER_DELETED;//"user deleted successfuly";
        }
        model.put("message", message);
        return new ModelAndView("redirect:/admin/role", model);
    }
    
    @RequestMapping(value = "/viewrole/{id}", method = RequestMethod.GET)
    public ModelAndView viewRole(@PathVariable Integer id, ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        Role role = roleService.getRole(id);
        model.put("role", role);
        return new ModelAndView("roles/viewrole", model);
    }
}
