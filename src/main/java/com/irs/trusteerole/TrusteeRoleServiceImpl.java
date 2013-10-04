package com.irs.trusteerole;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author 10014562
 */
@Service
@Transactional
public class TrusteeRoleServiceImpl implements TrusteeRoleService {
    private TrusteeRoleDAO trusteeRoleDAO;
    private PlatformTransactionManager transactionManager;
    
    @Autowired
    public void setTrusteeRoleDAO(TrusteeRoleDAO trusteeRoleDAO) {
        this.trusteeRoleDAO = trusteeRoleDAO;
    }
    
    @Autowired
    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }
    
    @Override
    @Transactional
    public void addTrusteeRole(TrusteeRole trusteeRole) {
        trusteeRoleDAO.save(trusteeRole);
    }

    @Override
    public TrusteeRole getTrusteeRole(Integer id) {
        return trusteeRoleDAO.getTrusteeRole(id);
    }

    @Override
    public void editTrusteeRole(TrusteeRole trusteeRole) {
        trusteeRoleDAO.editTrusteeRole(trusteeRole);
    }

    @Override
    public List<TrusteeRole> getTrusteeRoles() {
        return trusteeRoleDAO.getTrusteeRoles();
    }

    @Override
    @Transactional
    public boolean deleteTrusteeRole(Integer id) {
        return trusteeRoleDAO.delete(id);
    }
    
}
