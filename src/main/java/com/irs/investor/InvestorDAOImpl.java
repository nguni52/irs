package com.irs.investor;

import com.irs.trustee.Trustee;
import java.util.List;
import java.util.logging.Level;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author bmqolweni
 */
public class InvestorDAOImpl implements InvestorDAO {
    private SessionFactory sessionFactory;
    private Log log = LogFactory.getLog(InvestorDAOImpl.class.getName());

    @Autowired(required = true)
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    @Transactional
    public Integer saveInvestor(Investor investor){
        Session session = sessionFactory.getCurrentSession();//.persist(investor);
        //session.beginTransaction();
        Integer id = (Integer) session.save(investor);		
	//session.getTransaction().commit();		
	//session.close();
        
        return id;
    }

    @Override
    public Investor getInvestor(Integer id) {
        Investor investor = (Investor) sessionFactory.getCurrentSession().get(Investor.class, id);
        return investor;
    }

    @Override
    public void editInvestor(Investor investor) {
        sessionFactory.getCurrentSession().update(investor);
    }

    @Override
    public List<Investor> getInvestors() {
        return sessionFactory.getCurrentSession().createQuery("from Investor").list();
    }

    @Override
    public boolean deleteInvestor(Integer id) {
        try {
            Investor investor = (Investor) sessionFactory.getCurrentSession().load(Investor.class, id);
            try {
                sessionFactory.getCurrentSession().delete(investor);
                return true;
            } catch (Exception ex) {
                return false;
            }
        } catch(NullPointerException npe) {
            log.info("delete investor threw exception");
            return false;
        }
    }

    @Override
    public Investor getLatestInvestor() {
        try {
            Integer maxInvestorId;
            Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Investor.class).setProjection(Projections.max("investorID"));
            maxInvestorId = (Integer)criteria.uniqueResult();
            log.info("Max Investor Id: " + maxInvestorId);
            Investor investor = this.getInvestor(maxInvestorId);
            
            return investor;
        } catch(NullPointerException npe) {
            log.info("get latest investor threw npe");
            return null;
        }
    }
}
