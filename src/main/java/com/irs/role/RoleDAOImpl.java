/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.irs.role;

import com.irs.user.UserDAOImpl;
import java.util.List;
import java.util.logging.Level;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nkululekophakela
 */
@Repository
public class RoleDAOImpl implements RoleDAO {
    private static Log log = LogFactory.getLog(UserDAOImpl.class.getName());
    private SessionFactory sessionFactory;

    @Autowired(required = true)
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public int save(Role role) {
        Integer id = (Integer) sessionFactory.getCurrentSession().save(role);
        
        return id.intValue();
    }

    @Override
    public void editRole(Role role) {
        sessionFactory.getCurrentSession().update(role);
    }

    @Override
    public boolean deleteRole(Integer id) {
        Role role = (Role) sessionFactory.getCurrentSession().get(Role.class, id);
        if (null != role) {
            try {
                sessionFactory.getCurrentSession().delete(role);
                return true;
            } catch (Exception ex) {
                return false;
            }
        }

        return false;
    }

    @Override
    public Role getRole(Integer id) {
        Role role = (Role) sessionFactory.getCurrentSession().get(Role.class, id);
        return role;
    }

    @Override
    public List<Role> getRoles() {
        return sessionFactory.getCurrentSession().createCriteria(Role.class).list();
    }
    
    @Override
    public Integer getLatestRole() {
        Integer maxUserId = 1;
        try {
            Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Role.class).setProjection(Projections.max("roleId"));
            maxUserId = (Integer)criteria.uniqueResult();
        } catch(Exception ex) {
            log.debug(Level.SEVERE, ex);
        }
        
        return maxUserId;
    }

    @Override
    public void addRoles(List<Role> roleList) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        
        for(Role role: roleList) {
            Role newRole = new Role();
            newRole.setDescription(role.getDescription());
            session.save(newRole);
        }
        
        tx.commit();
        session.close();
    }
}
