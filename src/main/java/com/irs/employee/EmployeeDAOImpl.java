package com.irs.employee;

import java.util.List;
import java.util.logging.Level;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author lutendo
 */
public class EmployeeDAOImpl implements EmployeeDAO {
    private Log log = LogFactory.getLog(EmployeeDAOImpl.class.getName());
    private SessionFactory sessionFactory;
    
    @Autowired(required = true)
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public void saveEmployee(Employee employee){
        sessionFactory.getCurrentSession().save(employee);
    }

    @Override
    public Employee getEmployee(Integer id) {
        Employee employee = (Employee) sessionFactory.getCurrentSession().get(Employee.class, id);
        return employee;
    }

    @Override
    public void editEmployee(Employee employee) {
        sessionFactory.getCurrentSession().update(employee);
    }

    @Override
    public List<Employee> getEmployees() {
        //return sessionFactory.getCurrentSession().createQuery("from Employee").list();
        return sessionFactory.getCurrentSession().createCriteria(Employee.class).list();
    }

    @Override
    public boolean deleteEmployee(Integer id) {
        try {
            Employee employee = (Employee) sessionFactory.getCurrentSession().load(Employee.class, id);
            try {
                sessionFactory.getCurrentSession().delete(employee);
                return true;
            } catch (Exception ex) {
                return false;
            }
        } catch(NullPointerException npe) {
            log.info("delete employee threw exception");
            return false;
        }
    }
    
    @Override
    public Integer getLatestEmployee() {
        Integer maxUserId = 1;
        try {
            Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Employee.class).setProjection(Projections.max("userID"));
            maxUserId = (Integer)criteria.uniqueResult();
        } catch(Exception ex) {
            log.debug(Level.SEVERE, ex);
        }
        
        return maxUserId;
    } 
}
