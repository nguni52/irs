package com.irs.security;

/**
 *
 * @author Kenneth.Maposa
 */
import com.irs.user.User;
import com.irs.user.UserService;
import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

public class ExpiredPasswordFilter extends OncePerRequestFilter {
    private static final Log log = LogFactory.getLog(ExpiredPasswordFilter.class.getName());
    private UserService userService;
    
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws ServletException, IOException {
        try {
            //get the currently logged in user
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            UserDetails userDetails = null;
            if (principal instanceof UserDetails) {
                userDetails = (UserDetails) principal;
            }
            String username = userDetails.getUsername();
            
            log.info("username: " + username);

            User user = userService.getUserByUsername(username);
            if (user.getPasswordExpired() == 1) {
                res.sendRedirect("/irs/resetpassword");
            }
        } catch (NullPointerException npe) {
            log.debug("\n\n\n\n\n\n\n\n\n******************In catch********************\n\n\n\n\n", npe);
        }
        chain.doFilter(req, res);
    }
}