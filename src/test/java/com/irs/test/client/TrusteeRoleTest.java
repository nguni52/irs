package com.irs.test.client;


import com.irs.trusteerole.TrusteeRole;
import com.irs.trusteerole.TrusteeRoleService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

/**
 *
 * @author lutendo
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/trusteerole-context.xml", "/application-db-test-context.xml"})
public class TrusteeRoleTest {
    private static final Log log = LogFactory.getLog(TrusteeRoleTest.class.getName());
    
    @Autowired
    private TrusteeRoleService trusteeRoleService;

    @Test
    public void addTrusteeRoleTest() {
        // create an asset manager object
        TrusteeRole trusteeRole = new TrusteeRole();
        // set asset manager attributes
        trusteeRole.setTrusteeRoleDescription("The MAN");
        assertNotNull(trusteeRole);
        assertNotNull(trusteeRoleService);
        log.info(trusteeRole.toString());
        // save trustee role attributes in database
        //trusteeRoleService.addTrusteeRole(trusteeRole);
    }
}