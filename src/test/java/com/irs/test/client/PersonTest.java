/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.irs.test.client;

import com.irs.person.PersonService;
import com.irs.person.Title;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;
/**
 *
 * @author nkululekophakela
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/application-db-test-context.xml", "/person-context.xml"})
public class PersonTest {
    private static final Log log = LogFactory.getLog(PersonTest.class.getName());
    
    @Autowired
    PersonService personService;
    
    //@Test
    public void testAddTitles() {
        Title title = new Title();
        List<Title> titleList = new ArrayList<Title>();
        title.setTitle("Mr.");
        titleList.add(title);
        Title title1 = new Title();
        title1.setTitle("Mrs.");
        titleList.add(title1);
        Title title2 = new Title();
        title2.setTitle("Miss.");
        titleList.add(title2);
        Title title3 = new Title();
        title3.setTitle("Ms.");
        titleList.add(title3);
        Title title4 = new Title();
        title4.setTitle("Dr.");
        titleList.add(title4);
        Title title5 = new Title();
        title5.setTitle("Prof.");
        titleList.add(title5);
        assertNotNull(personService);
        personService.addTitles(titleList);
    }
    
    @Test
    public void testGetTitle() {
        assertNotNull(personService);
        Integer maxId = personService.getLatestTitle();
        Title title = personService.getTitle(maxId.intValue());
        assertNotNull(title);
    }
    
    @Test
    public void testEditTitle() {
        assertNotNull(personService);
        Integer maxId = personService.getLatestTitle();
        Title title = personService.getTitle(maxId.intValue());
        assertNotNull(title);
        title.setTitle("Doctor");
        //personService.editTitle(title);
    }
    
    @Test
    public void testGetTitles() {
        assertNotNull(personService);
        List<Title> titleList = personService.getTitles();
        assertNotNull(titleList);
    }
}