package com.irs.investor;

import java.util.List;

/**
 *
 * @author bmqolweni
 */
public interface InvestorDAO {
    public Integer saveInvestor(Investor investor);    
    public Investor getInvestor(Integer i);
    public void editInvestor(Investor investor);
    public List<Investor> getInvestors();
    public boolean deleteInvestor(Integer id);
    public Investor getLatestInvestor();
}
