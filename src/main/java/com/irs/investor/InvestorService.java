package com.irs.investor;

import java.util.List;

/**
 *
 * @author bmqolweni
 */
public interface InvestorService {
    public Integer addInvestor(Investor investor);
    public Investor getInvestor(Integer id);
    public void editInvestor(Investor investor);
    public List<Investor> getInvestors();
    public boolean deleteInvestor(Integer id);
    public Investor getLatestInvestor();
}
