package com.irs.trustee;

import java.util.List;
import java.util.logging.Level;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Kenneth.Maposa
 */
@Repository
public class TrusteeDAOImpl implements TrusteeDAO {
    private static final Log log = LogFactory.getLog(TrusteeDAOImpl.class.getName());
    
    private SessionFactory sessionFactory;
    //private Session session;
    
    @Autowired(required = true)
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        //session = sessionFactory.getCurrentSession();
    }
     
    /*
     * This method is used to save a new trustee record
     * 
     * @param trustee - The trustee  POJO with all the details to be saved
     * @access public
     * @return none
     * 
     */
    @Override
    public void saveTrustee(Trustee trustee) {
        sessionFactory.getCurrentSession().save(trustee);
    }

    /*
     * This method is used to update the details of the trustee
     * 
     * @param trustee - The details of the trustee that are to be updated
     * @access public
     * @return none
     * 
     */
    @Override
    public void editTrustee(Trustee trustee) {
        sessionFactory.getCurrentSession().update(trustee);
    }

    /*
     * The method is used to delete a trustee from the table.
     * 
     * @param id - The record id
     * @access public
     * @return true/false - The status of the deletion of the record
     * 
     */
    @Override
    public boolean deleteTrustee(Integer id) {
        Trustee trustee = (Trustee) sessionFactory.getCurrentSession().get(Trustee.class, id);
        if (null != trustee) {
            try {
                sessionFactory.getCurrentSession().delete(trustee);
                return true;
            } catch (Exception ex) {
                log.debug(Level.SEVERE, ex);
                return false;
            }
        }
        return false;
    }

    /*
     * This method retrieves the trustee record based on the id that is parsed in
     * 
     * @param id - The id of the record to retrieve
     * @access public
     * @return The trustee record if it exists
     * 
     */
    @Override
    public Trustee getTrustee(int id) {
        Trustee trustee = (Trustee) sessionFactory.getCurrentSession().get(Trustee.class, id);
        return trustee;
    }

    /*
     * This method return the latest record from the table. It works like max() in 
     * sql
     * @param none
     * @access pubic
     * @return the record for the last trustee added
     * 
     */
    @Override
    public Integer getLatestTrustee() {
        Integer maxTrusteeId = 1;
        try {
            Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Trustee.class).setProjection(Projections.max("trusteeId"));
            maxTrusteeId = (Integer)criteria.uniqueResult();
        } catch(Exception ex) {
            log.debug(Level.SEVERE, ex);
        }
        
        return maxTrusteeId;
    }

    @Override
    public List<Trustee> getTrustees() {
        return sessionFactory.getCurrentSession().createCriteria(Trustee.class).list();
    }
}