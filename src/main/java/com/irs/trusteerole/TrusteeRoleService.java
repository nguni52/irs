package com.irs.trusteerole;

import java.util.List;

/**
 *
 * @author 10014562
 */
public interface TrusteeRoleService {
    public void addTrusteeRole(TrusteeRole trusteeRole);
    public TrusteeRole getTrusteeRole(Integer id);
    public void editTrusteeRole(TrusteeRole trusteeRole);

    public List<TrusteeRole> getTrusteeRoles();

    public boolean deleteTrusteeRole(Integer id);
}
