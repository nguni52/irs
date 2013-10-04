package com.irs.employee;

import com.irs.employee.Employee;
import java.util.List;

/**
 *
 * @author lutendo
 */
public interface EmployeeService {
    public void addEmployee(Employee employee);
    public Employee getEmployee(Integer id);
    public void editEmployee(Employee employee);
    public List<Employee> getEmployees();
    public boolean deleteEmployee(Integer id);
    public Integer getLatestEmployee();
}


