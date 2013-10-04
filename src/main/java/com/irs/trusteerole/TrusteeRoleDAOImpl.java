package com.irs.trusteerole;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 10014562
 */
@Repository
public class TrusteeRoleDAOImpl implements TrusteeRoleDAO {
    private SessionFactory sessionFactory;

    @Autowired(required = true)
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(TrusteeRole trusteeRole) {
        sessionFactory.getCurrentSession().save(trusteeRole);
    }

    @Override
    public TrusteeRole getTrusteeRole(Integer id) {
        TrusteeRole trusteeRole = (TrusteeRole) sessionFactory.getCurrentSession().get(TrusteeRole.class, id);
        return trusteeRole;
    }

    @Override
    public void editTrusteeRole(TrusteeRole trusteeRole) {
        sessionFactory.getCurrentSession().update(trusteeRole);
    }

    @Override
    public List<TrusteeRole> getTrusteeRoles() {
         return sessionFactory.getCurrentSession().createQuery("from TrusteeRole").list();
    }

    @Override
    public boolean delete(Integer id) {
         TrusteeRole trusteeRole = (TrusteeRole) sessionFactory.getCurrentSession().load(TrusteeRole.class, id);
        if (null != trusteeRole) {
            try {
                sessionFactory.getCurrentSession().delete(trusteeRole);
                return true;
                
            } catch (Exception ex) {
                return false;
            }
        }

        return false;
    }
    
}
