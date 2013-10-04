package com.irs.trusteerole;

import java.util.List;

/**
 *
 * @author 10014562
 */
public interface TrusteeRoleDAO {

    public void save(TrusteeRole trusteeRole);
    public TrusteeRole getTrusteeRole(Integer id);
    public void editTrusteeRole(TrusteeRole trusteeRole);

    public List<TrusteeRole> getTrusteeRoles();

    public boolean delete(Integer id);
    
}
