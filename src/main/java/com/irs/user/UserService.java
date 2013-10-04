package com.irs.user;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.util.List;
import org.hibernate.exception.ConstraintViolationException;

/**
 *
 * @author nkululekophakela
 */
public interface UserService {

    public int addUser(User user) throws MySQLIntegrityConstraintViolationException, ConstraintViolationException;
    public void editUser(User user);
    public boolean deleteUser(Integer id);
    public List<User> getUsers();
    public User getUser(Integer id);
    public User getUserByUsername(String username);
    public String encodePassword(String plainPassword);
    public User getLatestUser();   
    public Authority getAuthority(String username);        
    public void editAuthority(Authority authority);
}
