package com.irs.person;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author Kenneth.Maposa
 */
public class PersonServiceImpl implements PersonService{
    private PersonDAO personDAO;
    private PlatformTransactionManager transactionManager;
    private static final Log log = LogFactory.getLog(PersonServiceImpl.class.getName());

    @Autowired
    public void setPersonDAO(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }
    
    @Autowired
    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }
    
    @Override
    @Transactional
    public List<Person> getPersons() {
        return personDAO.getPersons();
    }

    @Override
    @Transactional
    public Person getPerson(Integer id) {
        return personDAO.getPerson(id);
    }

    @Override
    @Transactional
    public void editPerson(Person person) {
        personDAO.edit(person);
    }

    @Override
    @Transactional
    public void addTitles(List<Title> titleList) {
        // save all the titles that are in the list
        personDAO.addTitles(titleList);
    }

    @Override
    @Transactional
    public Integer getLatestTitle() {
        return personDAO.getLatestTitle();
    }

    @Override
    @Transactional
    public Title getTitle(int id) {
        return personDAO.getTitle(id);
    }    

    @Override
    @Transactional
    public void saveTitle(Title title) {
        personDAO.saveTitle(title);
    }

    @Override
    @Transactional
    public List<Title> getTitles() {
        return personDAO.getTitles();
    }

    @Override
    @Transactional
    public void editTitle(Title title) {
        personDAO.editTitle(title);
    }
}
