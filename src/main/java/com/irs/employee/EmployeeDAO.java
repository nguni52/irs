package com.irs.employee;

import java.util.List;

/**
 *
 * @author lutendo
 */
public interface EmployeeDAO {
    public void saveEmployee(Employee employee);    
    public Employee getEmployee(Integer i);
    public void editEmployee(Employee employee);
    public List<Employee> getEmployees();
    public boolean deleteEmployee(Integer id);
    public Integer getLatestEmployee();
}
