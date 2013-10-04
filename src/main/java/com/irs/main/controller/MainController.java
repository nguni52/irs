package com.irs.main.controller;

import com.irs.user.User;
import com.irs.user.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author nguni52
 */
@Controller
public class MainController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getLoginPage(@RequestParam(value = "error", required = false) boolean error,
            ModelMap model, HttpServletRequest request) {
        //   Logger.init(request);

        if (error == true) {
            // Assign an error message
            model.put("error", "You have entered an invalid username or password");
        } else {
            model.put("error", "");
        }

        return new ModelAndView("login/index", model);
    }

    @RequestMapping(value = "/accessdenied", method = RequestMethod.GET)
    public ModelAndView getAccessDeniedPage(ModelMap model, HttpServletRequest request) {
        return new ModelAndView("error/accessdenied", model);
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView getIndexPage(ModelMap model, HttpServletRequest request) {

        return new ModelAndView("index", model);
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView getAdminPage(ModelMap model, HttpServletRequest request) {

        return new ModelAndView("admin/index", model);
    }

    @RequestMapping(value = "/resetpassword", method = RequestMethod.GET)
    public ModelAndView getResetPasswordPage(ModelMap model, HttpServletRequest request) {
        
        return new ModelAndView("resetpassword/index", model);
    }
    
    @RequestMapping(value = "/resetpassword", method = RequestMethod.POST)
    public ModelAndView getResetPasswordPage(ModelMap model, HttpServletRequest request, HttpServletResponse response) {

        String password = request.getParameter("password");
        String password1 = request.getParameter("password1");

        //get the currently logged in user
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = null;
        if (principal instanceof UserDetails) {
            userDetails = (UserDetails) principal;
        }
        String username = userDetails.getUsername();

        User user = userService.getUserByUsername(username);
        if (password.equals(password1)) {
            //System.out.println("IN IF passwor does not match ");
            password = userService.encodePassword(password);
            user.setPassword(password);
            user.setPasswordExpired(0);
            userService.editUser(user);
            return new ModelAndView("redirect:/index", model);
        }
        else{
            System.out.println("passwor does not match ");
            user.setPasswordExpired(1);
            userService.editUser(user);
            return new ModelAndView("redirect:/resetpassword", model);
        }
    }
    
    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public ModelAndView getAboutPage(ModelMap model, HttpServletRequest request) {

        return new ModelAndView("frontpage/about", model);
    }
    
    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public ModelAndView getContactPage(ModelMap model, HttpServletRequest request) {

        return new ModelAndView("frontpage/contact", model);
    }
}
