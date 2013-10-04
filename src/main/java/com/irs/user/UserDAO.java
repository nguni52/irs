package com.irs.user;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.util.List;
import org.hibernate.exception.ConstraintViolationException;

/**
 *
 * @author nkululekophakela
 */
public interface UserDAO {
    public int save(User user) throws MySQLIntegrityConstraintViolationException, ConstraintViolationException;
    public void edit(User user);
    public boolean delete(Integer id);
    public List<User> getUsers();
    public User getUser(Integer id);
    public User getUserByUsername(String username);
    public User getLatestUser();    
    public Authority getAuthority(String username);
    public void editAuthority(Authority authority);
}