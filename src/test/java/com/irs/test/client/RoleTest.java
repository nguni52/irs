/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.irs.test.client;

import com.irs.role.Role;
import com.irs.role.RoleService;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNotNull;
/**
 *
 * @author nkululekophakela
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/application-db-test-context.xml", "/role-context.xml"})
public class RoleTest {
    private static final Log log = LogFactory.getLog(PersonTest.class.getName());
    
    @Autowired
    RoleService roleService;
    
    @Test
    public void testAddRoles() {
        List<Role> roleList = new ArrayList<Role>();
        Role role = new Role();
        role.setDescription("ROLE_ADMIN");
        Role role1 = new Role();
        role1.setDescription("ROLE_SUPPORT");
        Role role2 = new Role();
        role2.setDescription("ROLE_TEST1");
        Role role3 = new Role();
        role3.setDescription("ROLE_TEST2");
        
        roleList.add(role);
        roleList.add(role1);
        roleList.add(role2);
        roleList.add(role3);
        roleService.addRoles(roleList);
    }
    
    //@Test
    public void testAddRole() {
        assertNotNull(roleService);
        Role role = new Role();
        role.setDescription("ROLE_ADMIN");
        roleService.save(role);
    }
    
    @Test
    public void testEditRole() {
        assertNotNull(roleService);
        Integer id = roleService.getLatestRole();
        int newId = id.intValue();
        newId-=1;
        Role role = roleService.getRole(new Integer(newId));
        role.setDescription("ROLE_USER");
        roleService.editRole(role);
    }
    
    @Test
    public void testDeleteRole() {
        assertNotNull(roleService);
        Integer id = roleService.getLatestRole();
        boolean status = roleService.deleteRole(id);
        log.info("\n\n\n\n\n********************************\n\n\n\n\n");
        if(status) {
            log.info("The role with id: " + id + " was deleted successfully");
        } else {
            log.info("The role with id: " + id + " was not deleted successfully");
        }
        log.info("\n\n\n\n\n********************************\n\n\n\n\n");
    }
    
    @Test
    public void testGetRole() {
        Integer id = roleService.getLatestRole();
        Role role = roleService.getRole(id);
        log.info("\n\n\n\n\n********************************\n\n\n\n\n");
        log.info("Role ID: " + role.getRoleId());
        log.info("Role Description: " + role.getDescription());
        log.info("\n\n\n\n\n********************************\n\n\n\n\n");
    }
    
    @Test
    public void testGetRoles() {
        assertNotNull(roleService);
        List<Role> roleList = roleService.getRoles();
        log.info("\n\n\n\n\n********************************\n\n\n\n\n");
        for(Role role : roleList) {
            log.info("Role ID: " + role.getRoleId());
            log.info("Role Description: " + role.getDescription());
            log.info("\n\n");
        }
        log.info("\n\n\n\n\n********************************\n\n\n\n\n");
    }
}
