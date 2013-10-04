package com.irs.trustee;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Kenneth.Maposa
 */
public class TrusteeServiceImpl implements TrusteeService {
    private TrusteeDAO trusteeDAO;
    private PlatformTransactionManager transactionManager;

    @Autowired
    public void setTrusteeDAO(TrusteeDAO trusteeDAO) {
        this.trusteeDAO = trusteeDAO;
    }
    
    @Autowired
    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }
    
    @Override
    @Transactional
    public void addTrustee(Trustee trustee) {
        trusteeDAO.saveTrustee(trustee);
    }

    @Override
    @Transactional
    public void editTrustee(Trustee trustee) {
        trusteeDAO.editTrustee(trustee);
    }

    @Override
    @Transactional
    public boolean deleteTrustee(Integer id) {        
        return trusteeDAO.deleteTrustee(id);
    }

    @Override
    @Transactional
    public Trustee getTrustee(int id) {
        return trusteeDAO.getTrustee(id);
    }    

    @Override
    @Transactional
    public Integer getLatestTrustee() {
        return trusteeDAO.getLatestTrustee();
    }
    
    @Override
    @Transactional
    public List<Trustee> getTrustees() {
        return trusteeDAO.getTrustees();
    }
}