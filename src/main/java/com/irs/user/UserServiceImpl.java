package com.irs.user;

import com.irs.person.PersonService;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author nkululekophakela
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    private static final Log log = LogFactory.getLog(UserServiceImpl.class.getName());

    private UserDAO userDAO;
    private PersonService personService;    
    private PlatformTransactionManager transactionManager;
    
    @Autowired
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }
    
    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Autowired
    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    /**
     *
     * @param user
     */
    @Override
    @Transactional
    public int addUser(User user) throws MySQLIntegrityConstraintViolationException, ConstraintViolationException {
        user.setPassword(encodePassword(user.getPassword()));
        return userDAO.save(user);
    }

    @Override
    @Transactional
    public void editUser(User user) {
        userDAO.edit(user);
    }

    /**
     *
     * @return
     */
    @Override
    @Transactional
    public List<User> getUsers() {
        return userDAO.getUsers();
    }

    /**
     *
     * @param id
     */
    @Transactional
    @Override
    public boolean deleteUser(Integer id) {
        return userDAO.delete(id);
    }

    @Override
    public User getUser(Integer id) {
        return userDAO.getUser(id);
    }

    @Override
    public String encodePassword(String plainPassword) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(plainPassword.getBytes(), 0, plainPassword.length());
            String hashedPass = new BigInteger(1, messageDigest.digest()).toString(16);
            if (hashedPass.length() < 32) {
                hashedPass = "0" + hashedPass;
            }
            
            return hashedPass;
        } catch (NoSuchAlgorithmException ex) {
            log.debug(Level.SEVERE, ex);
            return null;
        }
    }   

    @Override
    public User getUserByUsername(String username) {
        return userDAO.getUserByUsername(username);
    }

    @Override
    public User getLatestUser() {
        return userDAO.getLatestUser();
    }    

    @Override
    public Authority getAuthority(String username) {
        return userDAO.getAuthority(username);
    }

    @Override
    public void editAuthority(Authority authority) {
        userDAO.editAuthority(authority);
    }
}