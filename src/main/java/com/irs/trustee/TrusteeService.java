package com.irs.trustee;

import java.util.List;

/**
 *
 * @author Kenneth.Maposa
 */
public interface TrusteeService {    
    public void addTrustee(Trustee trustee);
    public void editTrustee(Trustee trustee);
    public boolean deleteTrustee(Integer id);    
    public Trustee getTrustee(int id);
    public Integer getLatestTrustee();
    public List<Trustee> getTrustees();
}
