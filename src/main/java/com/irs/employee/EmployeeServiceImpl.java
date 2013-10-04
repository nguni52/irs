package com.irs.employee;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lutendo
 */
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDAO employeeDAO;
    private PlatformTransactionManager transactionManager;
    
    @Autowired
    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }
    
    @Autowired
    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }
    
    @Override
    @Transactional
    public void addEmployee(Employee employee) {
        employeeDAO.saveEmployee(employee);
    }

    @Override
    @Transactional
    public Employee getEmployee(Integer id) {
        return employeeDAO.getEmployee(id);
    }

    @Override
    @Transactional
    public void editEmployee(Employee employee) {
        employeeDAO.editEmployee(employee);
    }

    @Override
    @Transactional
    public List<Employee> getEmployees() {
        return employeeDAO.getEmployees();
    }

    @Override
    @Transactional
    public boolean deleteEmployee(Integer id) {
        return employeeDAO.deleteEmployee(id);
    }
    
    @Override
    public Integer getLatestEmployee() {
        return employeeDAO.getLatestEmployee();
    }
}


