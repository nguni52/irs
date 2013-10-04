package com.irs.investor;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author bmqolweni
 */
public class InvestorServiceImpl implements InvestorService {
    private InvestorDAO investorDAO;
    private PlatformTransactionManager transactionManager;
    
    @Autowired
    public void setInvestorDAO(InvestorDAO investorDAO) {
        this.investorDAO = investorDAO;
    }
    
    @Autowired
    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }
    
    @Override
    @Transactional
    public Integer addInvestor(Investor investor) {
        return investorDAO.saveInvestor(investor);
    }

    @Override
    @Transactional
    public Investor getInvestor(Integer id) {
        return investorDAO.getInvestor(id);
    }

    @Override
    @Transactional
    public void editInvestor(Investor investor) {
        investorDAO.editInvestor(investor);
    }

    @Override
    @Transactional
    public List<Investor> getInvestors() {
        return investorDAO.getInvestors();
    }

    @Override
    @Transactional
    public boolean deleteInvestor(Integer id) {
        return investorDAO.deleteInvestor(id);
    }

    @Override
    @Transactional
    public Investor getLatestInvestor() {
        return investorDAO.getLatestInvestor();
    }
}
