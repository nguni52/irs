package com.irs.interceptor;

import com.irs.person.Person;
import com.irs.user.User;
import com.irs.user.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author lutendo
 */
@Component
public class UserInterceptor extends HandlerInterceptorAdapter {

    private static final Log log = LogFactory.getLog(UserInterceptor.class.getName());
    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        try {
            if (request.getUserPrincipal() != null) {
                if (SecurityContextHolder.getContext().getAuthentication() != null
                        && SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
                    //get the currently logged in user
                    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                    UserDetails userDetails = null;
                    if (principal instanceof UserDetails) {
                        userDetails = (UserDetails) principal;
                    }
                    String username = userDetails.getUsername();

                    log.info("username: " + username);

                    User user = userService.getUserByUsername(username);
                    for(Person person: user.getPerson()) {
                        try {
                            modelAndView.addObject("current_person", person);
                        } catch(NullPointerException npe) {
                            log.info("Person throwing an npe");
                        }
                    }
                    if (modelAndView != null) {
                        modelAndView.addObject("user", user);
                    }
                }
            }
        } catch (SystemException e) {
            log.info("request update failed");
        }
        super.postHandle(request, response,handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        System.out.println("After completion handle");
    }

    private class SystemException extends RuntimeException {

        private static final long serialVersionUID = 1L;
        // Blank
    }
}