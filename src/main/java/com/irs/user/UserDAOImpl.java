package com.irs.user;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.logging.Level;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nkululekophakela
 */
@Repository
public class UserDAOImpl implements UserDAO {
    private static Log log = LogFactory.getLog(UserDAOImpl.class.getName());
    private SessionFactory sessionFactory;

    @Autowired(required = true)
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public int save(User user) throws MySQLIntegrityConstraintViolationException, ConstraintViolationException {
        String username = (String)sessionFactory.getCurrentSession().save(user);
        Integer id = this.getUserByUsername(username).getUserID();
        return id.intValue();
    }

    @Override
    public void edit(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public boolean delete(Integer id) {
        User user = (User) sessionFactory.getCurrentSession().get(User.class, id);
        if (null != user) {
            try {
                sessionFactory.getCurrentSession().delete(user);
                return true;
            } catch (Exception ex) {
                log.debug(ex);
                return false;
            }
        }

        return false;
    }

    @Override
    public List<User> getUsers() {
        return sessionFactory.getCurrentSession().createCriteria(User.class).list();
    }

    @Override
    public User getUser(Integer id) {
        User user = (User) sessionFactory.getCurrentSession().get(User.class, id);
        return user;
    }

    @Override
    public User getUserByUsername(String username) {
        User user = (User) sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq("username", username)).uniqueResult();
        return user;
    }

    @Override
    public User getLatestUser() {
        Integer maxUserId = 1;
        try {
            Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class).setProjection(Projections.max("userID"));
            maxUserId = (Integer)criteria.uniqueResult();
        } catch(Exception ex) {
            log.debug(Level.SEVERE, ex);
        }
        
        User user=null;
        try {
            if(maxUserId > 1) {
                user = this.getUser(maxUserId);
            }
        } catch(Exception ex) {
            log.debug(Level.SEVERE, ex);
        }
        
        return user;
    }    

    @Override
    public Authority getAuthority(String username) {
        Authority authority = (Authority) sessionFactory.getCurrentSession().get(Authority.class, username);
        return authority;
    }

    @Override
    public void editAuthority(Authority authority) {
        sessionFactory.getCurrentSession().update(authority);
    }
}