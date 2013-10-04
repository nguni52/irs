/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.irs.role;

import java.util.List;

/**
 *
 * @author nkululekophakela
 */
public interface RoleService {
    public int save(Role role);
    public void editRole(Role role);
    public boolean deleteRole(Integer id);
    public Role getRole(Integer id);
    public List<Role> getRoles();
    public Integer getLatestRole();
    public void addRoles(List<Role> roleList);
}
