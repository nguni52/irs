/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.irs.role;

import com.irs.user.UserServiceImpl;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author nkululekophakela
 */
@Service
public class RoleServiceImpl implements RoleService {
    private static final Log log = LogFactory.getLog(UserServiceImpl.class.getName());

    private RoleDAO roleDAO;
    private PlatformTransactionManager transactionManager;

    @Autowired
    public void setRoleDAO(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Autowired
    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }
    
    @Override
    @Transactional
    public int save(Role role) {
        return roleDAO.save(role);
    }

    @Override
    @Transactional
    public void editRole(Role role) {
        roleDAO.editRole(role);
    }

    @Override
    @Transactional
    public boolean deleteRole(Integer id) {
        return roleDAO.deleteRole(id);
    }

    @Override
    @Transactional
    public Role getRole(Integer id) {
        return roleDAO.getRole(id);
    }

    @Override
    @Transactional
    public List<Role> getRoles() {
        return roleDAO.getRoles();
    }

    @Override
    @Transactional
    public Integer getLatestRole() {
        return roleDAO.getLatestRole();
    }

    @Override
    public void addRoles(List<Role> roleList) {
        roleDAO.addRoles(roleList);
    }
}
