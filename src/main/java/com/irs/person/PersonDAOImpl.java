/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.irs.person;

import java.util.List;
import java.util.logging.Level;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Kenneth.Maposa
 */
@Repository
public class PersonDAOImpl implements PersonDAO {

    private static Log log = LogFactory.getLog(PersonDAOImpl.class.getName());
    private SessionFactory sessionFactory;

    @Autowired(required = true)
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public List<Person> getPersons() {
        return sessionFactory.getCurrentSession().createCriteria(Person.class).list();
    }

    @Override
    public Person getPerson(Integer id) {
        Person person = (Person) sessionFactory.getCurrentSession().get(Person.class, id);
        return person;
    }

    @Override
    public void edit(Person person) {
        sessionFactory.getCurrentSession().update(person);
    }

    @Override
    public void addTitles(List<Title> titleList) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        
        for(Title title: titleList) {
            Title newTitle = new Title();
            newTitle.setTitle(title.getTitle());
            session.save(newTitle);
        }
        
        tx.commit();
        session.close();
    }

    @Override
    public Title getTitle(int id) {
        Title title = (Title) sessionFactory.getCurrentSession().get(Title.class, id);
        return title;
    }

    @Override
    public Integer getLatestTitle() {
        Integer maxTitleId = 1;
        try {
            Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Title.class).setProjection(Projections.max("titleId"));
            maxTitleId = (Integer)criteria.uniqueResult();
        } catch(Exception ex) {
            log.debug(Level.SEVERE, ex);
        }
        
        return maxTitleId;
    }

    @Override
    public void saveTitle(Title title) {
        sessionFactory.getCurrentSession().save(title);
    }

    @Override
    public List<Title> getTitles() {
        return sessionFactory.getCurrentSession().createCriteria(Title.class).list();
    }

    @Override
    public void editTitle(Title title) {
        sessionFactory.getCurrentSession().update(title);
    }
}